pipeline {
    agent  any

    environment {
        DOCKER_COMPOSE = 'docker compose -f docker-compose.yml'
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

        stage('Archive Results') {
            steps {
                junit '**/target/surefire-reports/**/*.xml'
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }

    post {
        always {
            echo 'Cleaning up containers...'
            sh "${DOCKER_COMPOSE} down"
        }
    }
}
