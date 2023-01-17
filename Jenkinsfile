pipeline {

  agent any
  
  stages {
    stage('Build') {
      steps { bat 'mvn clean package -DskipTests' }
    }

    stage('Test') {
      parallel {
        stage('Unit tests') {
            steps { bat 'mvn verify' }
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
	

	stage ( 'API Automation') {
		steps() {
			bat 'newman run News_Group_API_postman_collection.json -r htmlextra --reporter-htmlextra-export ./newman/report.html'
		publishHTML target: [
				allowMissing: false,
				alwaysLinkToLastBuild: false,
				keepAll: true,
				reportDir: '.\newman',
				reportFiles: 'report.html',
				reportName: 'Newman HTML Reporter'
		]
	}

    stage('Docker Build') {
      steps {
		echo "..... Docker Build"
			bat 'docker build Dockerfile -t rajeshazure1980/public:news-search .'
		}
    }
	
	stage('Docker Publish') {
      steps {
		echo "..... Docker Build"
			bat 'docker push rajeshazure1980/news-search:latest'
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