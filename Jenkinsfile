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
                stage('Report') {
                    steps {
                        publishHTML(target: [
                            reportName: 'Selenium Test Report',
                            reportDir: 'target/surefire-reports',
                            reportFiles: 'index.html',
                            alwaysLinkToLastBuild: true,
                            keepAll: true
                        ])
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Archiving results...'
            junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'

            echo 'Cleaning up containers...'
            sh "${DOCKER_COMPOSE} down"
        }
    }
}
