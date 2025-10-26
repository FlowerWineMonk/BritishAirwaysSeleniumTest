pipeline {
    agent  any

    environment {
        DOCKER_COMPOSE = 'docker compose -f docker-compose.yml'
        RUN_CHROME = false
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean Previous Results') {
            steps {
                sh '''
                  docker run --rm \
                    --user 1000:1000 \
                    -v jenkins_home:/var/jenkins_home \
                    alpine:3.18 \
                    sh -c "rm -rf /var/jenkins_home/workspace/SeleniumGridPipeline/target || true"
                '''
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
                    results: [[path: 'target/allure-results']]
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
