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
        always {
            emailext(
                subject: "📢 Build Completed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    <p>Build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> finished.</p>
                    <p><a href="${env.BUILD_URL}console">View Build Logs</a></p>
                """,
                to: "amit33301@gmail.com, abhishekse@outlook.com",
                mimeType: "text/html"
            )
        }
    }
}
