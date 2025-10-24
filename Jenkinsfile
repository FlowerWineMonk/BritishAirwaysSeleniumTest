pipeline {
    agent  any

    environment {
        DOCKER_COMPOSE = 'docker compose -f docker-compose.yml'
        RUN_CHROME = false
        ALLURE_RESULTS_DIR = 'allure-results'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean Previous Results') {
            steps {
                sh """
                    rm -rf ${ALLURE_RESULTS_DIR} || true
                    rm -rf target/allure-results || true
                """
            }
        }

        stage('Start Selenium Grid') {
           steps {
              sh """
                  ${DOCKER_COMPOSE} down || true
                  docker rm -f selenium-hub || true
                  ${DOCKER_COMPOSE} up -d selenium-hub chrome firefox
              """
            }
        }

        stage('Run Tests in Parallel') {
            parallel {
                stage('Chrome Tests') {
                    when {
                        expression { return env.RUN_CHROME == 'true' }
                    }
                    steps {
                        sh """
                            ${DOCKER_COMPOSE} run --rm maven-tests \
                              mvn clean test \
                              -Dbrowser=remote-chrome \
                              -DhubHost=selenium-hub \
                              -Dci=true
                        """
                    }
                }

                stage('Firefox Tests') {
                    steps {
                        sh """
                            ${DOCKER_COMPOSE} run --rm maven-tests \
                              mvn clean test \
                              -Dbrowser=remote-firefox \
                              -DhubHost=selenium-hub \
                              -Dci=true
                        """
                    }
                }

            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    sh """
                        docker run --rm \
                          -v jenkins_home:/var/jenkins_home \
                          -v \$(pwd):/workspace \
                          alpine:latest \
                          sh -c 'cp -r /var/jenkins_home/workspace/SeleniumGridPipeline/allure-results /workspace/ || true'
                    """

                    sh """
                        ${DOCKER_COMPOSE} run --rm maven-tests \
                          mvn allure:report
                    """

                    sh """
                        docker run --rm \
                          -v jenkins_home:/var/jenkins_home \
                          -v \$(pwd):/workspace \
                          alpine:latest \
                          sh -c 'cp -r /var/jenkins_home/workspace/SeleniumGridPipeline/target/site/allure-maven-plugin /workspace/target/site/ || true'
                    """
                }
            }
        }

    }

    post {
        always {
            script {
                echo 'Archiving test results...'
                
                junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
                
                echo 'Cleaning up containers...'
                sh "${DOCKER_COMPOSE} down"
            }
        }

        success {
            echo 'Pipeline completed successfully!'
        }
        
        failure {
            echo 'Pipeline failed. Check the Allure report for details.'
        }
    }
}
