pipeline {
    agent any
    triggers { 
        githubPush() 
    }
    environment {
        DOCKER_IMAGE_NAME = 'sci-calc-aks'
        GITHUB_REPO_URL = 'https://github.com/aks-master/SciCalcAKS'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build with Maven') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'DockerHubCred') {
                        sh "docker tag ${DOCKER_IMAGE_NAME} aks00798/${DOCKER_IMAGE_NAME}:latest"
                        sh "docker push aks00798/${DOCKER_IMAGE_NAME}"
                    }
                }
            }
        }

        stage('Run Ansible Deployment') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: "ansible/deploy.yml",
                        inventory: "ansible/inventory"
                    )
                }
            }
        }
    }

    post {
        success {
            emailext subject: "Build Successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "Build ${env.JOB_NAME} #${env.BUILD_NUMBER} succeeded.\nLogs: ${env.BUILD_URL}",
                     to: "amit33301@gmail.com"
        }

        failure {
            emailext subject: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                     body: "Build ${env.JOB_NAME} #${env.BUILD_NUMBER} failed.\nLogs: ${env.BUILD_URL}",
                     to: "amit33301@gmail.com"
        }
    }
}
