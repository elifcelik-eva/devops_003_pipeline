pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/elifcelik-eva/devops_003_pipeline.git']])
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Docker Image') {
            steps {
                bat 'docker build -t elifcelik49/devops-application:latest  . '
            }
        }
        stage('DockerHub Push') {
            steps {
                withCredentials([usernameColonPassword(credentialsId: 'dockerID', variable: 'dockerHub')]) {
                    bat 'docker push elifcelik49/devops-application:latest'
                }
            }
        }
        stage('K8s') {
            steps {
                kubernetesDeploy configs: 'deployment-service.yaml', kubeconfigId: 'kubernetesID', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
            }
        }
    }
    post {
        success {
            echo 'Build completed successfully!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
