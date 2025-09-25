pipeline {
    agent {
        docker {
            image 'docker:24.0.7-dind'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

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
                sh "${DOCKER_COMPOSE} up -d selenium-hub chrome firefox"
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

                            mkdir -p target/allure-results/chrome
                            mv target/allure-results/* target/allure-results/chrome/ || true

                            mkdir -p target/surefire-reports/chrome
                            mv target/surefire-reports/* target/surefire-reports/chrome/ || true
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

                            mkdir -p target/allure-results/firefox
                            mv target/allure-results/* target/allure-results/firefox/ || true

                            mkdir -p target/surefire-reports/firefox
                            mv target/surefire-reports/* target/surefire-reports/firefox/ || true
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
