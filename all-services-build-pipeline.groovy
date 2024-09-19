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
                    echo 'Deploying the eureka-server'
                    bat 'java -jar target/eureka-server-0.0.1-SNAPSHOT.jar'
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
        }
}
