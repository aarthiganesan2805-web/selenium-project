pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/aarthiganesan2805-web/selenium-project.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo 'Selenium execution completed.'
        }

        success {
            echo 'Selenium tests passed!'
        }

        failure {
            echo 'Selenium tests failed!'
        }
    }
}