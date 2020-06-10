pipeline {
    agent any
    environment {
        registry = 'imgomi/calculator'
        registryCredential = 'dockerhub'
        dockerImage = ''
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/aid95/calculator.git'
            }
        }
        stage('Init') {
            steps {
                sh 'chmod +x gradlew'
            }
        }
        stage('Compile') {
            steps {
                sh './gradlew compileJava'
            }
        }
        stage('Unit test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Code coverage test') {
            steps {
                sh './gradlew jacocoTestReport'
                publishHTML (target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                sh './gradlew jacocoTestCoverageVerification'
            }
        }
        stage ('Static Code Analysis'){
            steps {
                sh "./gradlew checkstyleMain"
                publishHTML (target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: "Checkstyle Report"
                ])
            }
        }
        stage ('Packaging') {
            steps {
                sh './gradlew build'
            }
        }
        stage ('Deploy image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}
