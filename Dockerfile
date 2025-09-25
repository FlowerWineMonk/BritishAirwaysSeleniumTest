FROM jenkins/jenkins:lts

USER root
RUN groupadd -g 994 dockerhost \
  && usermod -aG dockerhost jenkins \
  && apt-get update && apt-get install -y docker.io docker-compose \
  && rm -rf /var/lib/apt/lists/*
USER jenkins
