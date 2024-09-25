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

        stage('Build') {
            steps {
                dir('eureka-server')
        {
                    // Clean and build the Maven project
                    echo 'Building eureka-server service...'
                    sh 'mvn clean package'
                    echo 'Deploying the eureka-server'
                    sh 'nohup java -jar target/eureka-server-0.0.1-SNAPSHOT.jar'
        }
                    dir('apigateway')
        {
                    // Clean and build the Maven project
                    echo 'Building apigateway service...'
                    sh 'mvn clean package'
        }
                    dir('configserver')
        {
                    // Clean and build the Maven project
                    echo 'Building configserver service...'
                    sh 'mvn clean package'
        }
                    dir('springsecurityjwt')
        {
                    // Clean and build the Maven project
                    echo 'Building springsecurityjwt service...'
                    sh 'mvn clean package'
        }
                    dir('userservice')
        {
                    // Clean and build the Maven project
                    echo 'Building userservice service...'
                    sh 'mvn clean package'
        }
                    dir('productservice')
        {
                    // Clean and build the Maven project
                    echo 'Building productservice service...'
                    sh 'mvn clean package'
        }
                    dir('configclient')
        {
                    // Clean and build the Maven project
                    echo 'Building configclient service...'
                    sh 'mvn clean package'
        }
            }
        }
        }
}