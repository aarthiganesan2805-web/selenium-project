pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {

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