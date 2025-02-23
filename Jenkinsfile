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
                        sh "docker tag ${DOCKER_IMAGE_NAME} aks-master/${DOCKER_IMAGE_NAME}:latest"
                        sh "docker push aks-master/${DOCKER_IMAGE_NAME}:latest"
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
            script {
                emailext(
                    subject: "✅ Build Successful: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """<p>Build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> succeeded.</p>
                             <p><a href="${env.BUILD_URL}">Click here for logs</a></p>""",
                    to: "amit33301@gmail.com",
                    mimeType: "text/html"
                )
            }
        }

        failure {
            script {
                emailext(
                    subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                    body: """<p>Build <b>${env.JOB_NAME} #${env.BUILD_NUMBER}</b> failed.</p>
                             <p><a href="${env.BUILD_URL}">Click here for logs</a></p>""",
                    to: "amit33301@gmail.com",
                    mimeType: "text/html"
                )
            }
        }
    }
}
