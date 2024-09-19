/* groovylint-disable-next-line CompileStatic */
pipeline {
        agent any
        tools {
        maven 'MAVEN_HOME' // Use the name of the Maven installation you added
        }
        stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/vikarm-verma/docker-repo.git'
            }
        }

        stage('Build') {
            steps {
                dir('eureka-server')
        {
                    // Clean and build the Maven project
                    echo 'Building eureka-server service...'
                    bat 'mvn clean package'
        }
                    dir('apigateway')
        {
                    // Clean and build the Maven project
                    echo 'Building apigateway service...'
                    bat 'mvn clean package'
        }
                    dir('configserver')
        {
                    // Clean and build the Maven project
                    echo 'Building configserver service...'
                    bat 'mvn clean package'
        }
                    dir('springsecurityjwt')
        {
                    // Clean and build the Maven project
                    echo 'Building springsecurityjwt service...'
                    bat 'mvn clean package'
        }
                    dir('userservice')
        {
                    // Clean and build the Maven project
                    echo 'Building userservice service...'
                    bat 'mvn clean package'
        }
                    dir('productservice')
        {
                    // Clean and build the Maven project
                    echo 'Building productservice service...'
                    bat 'mvn clean package'
        }
                    dir('configclient')
        {
                    // Clean and build the Maven project
                    echo 'Building configclient service...'
                    bat 'mvn clean package'
        }
                }
        }
        stage('Docker Build and Run') {
            steps {
                echo 'Building and running Docker containers...'
                // Build and run all services using docker-compose
                bat 'docker-compose -f docker-compose.yml up --build -d'
            }
        }
    }
}
