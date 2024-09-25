/* groovylint-disable-next-line CompileStatic */
pipeline {
        agent any
        tools {
        maven 'MAVEN_HOME' // Use the name of the Maven installation you added
        }
   stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vikarm-verma/ec2-repo.git'
            }
        }
        stage('Docker Build and Run') {
            steps {
                echo 'Building and running Docker containers...'
                // Build and run all services using docker-compose
		sh 'docker-compose down'
                sh 'docker-compose build --no-cache'
		sh 'docker-compose up'
            }
        }
        }
}