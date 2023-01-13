pipeline {
    environment {
        VERSION = '1.0'
        REGISTRY = 'raajeshem80/NewsSearch'
        REGISTRY_CREDENTIAL = 'mydockercredentials'
		DOCKERHUB_CREDENTIALS=credentials('mydockercredentials')
    }
  agent any
  
  stages {
    stage('Build') {
      steps { bat 'mvn -f spring-security-refresh-token-jwt/ clean package -DskipTests' }
    }

    stage('Test') {
      parallel {
        stage('Unit tests') {
            steps { bat 'mvn -f spring-security-refresh-token-jwt/ verify' }
        }
      }
    }
	
	stage ( 'SonarQube analysis') {
		environment {

        scannerhome= tool 'SonarRunner'

		}

	   steps {
		echo "..... Sonar"
		}
	}
	
    stage('Docker Build') {
      steps {
		echo "..... Docker Build"
			bat 'docker build -f spring-security-refresh-token-jwt/Dockerfile -t rajeshazure1980/spring-security-refresh-token .'
		}
    }
	
	stage('Docker Publish') {
      steps {
		echo "..... Docker Build"
			bat 'docker login -u rajeshazure1980 -p Gowshik@12 docker.io'
			bat 'docker push rajeshazure1980/spring-security-refresh-token:latest'
		}
    }
  }
  
  post {
    failure {
      // notify users when the Pipeline fails
	  echo "..... failure ${currentBuild.fullDisplayName}"
      mail to: 'rajesh.em@gmail.com',
          subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
          body: "Something is wrong with ${env.BUILD_URL}"
    }
	
	always {
		bat 'docker logout'
	}
  }
}