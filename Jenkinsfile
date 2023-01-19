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
			withSonarQubeEnv('sonarqube') {
				bat "${scannerhome}\\sonar-scanner \
				  -D sonar.login=admin \
				  -D sonar.password=admin123 \
				  -D sonar.projectKey=News-Group \
				  -D sonar.projectName=News-Group-API \
				  -D sonar.projectVersion=1.0 \
				  -D sonar.sources=src \
				  -D sonar.coverage.jacoco.xmlReportPaths=target/jacoco/jacoco.xml \
				  -D sonar.host.url=http://localhost:9000/ \
				  -D sonar.java.binaries=target/classes \
				  -D sonar.language=java"
				publishHTML target: [
					allowMissing: true,
					alwaysLinkToLastBuild: true,
					keepAll: true,
					reportDir: '\\target\\jacoco',
					reportFiles: 'index.html',
					reportName: 'Coverage Report'
				]				  
			}
		}
	}
	

	stage ( 'API Automation') {
		steps() {
			echo "..... API Automation Start"
			bat 'newman run News_Group_API_postman_collection.json -r htmlextra --reporter-htmlextra-export ./newman/report.html'
			publishHTML target: [
					allowMissing: false,
					alwaysLinkToLastBuild: false,
					keepAll: true,
					reportDir: 'newman',
					reportFiles: 'report.html',
					reportName: 'Newman HTML Reporter'
			]
			echo "..... API Automation End"
		}
	}

    stage('Docker Build') {
      steps {
		echo "..... Docker Build"
			bat 'docker build -t rajeshazure1980/news-group-api .'
		}
    }
	
	stage('Docker Publish') {
      steps {
		echo "..... Docker Build"
			bat 'docker login -u rajeshazure1980 -p Gowshik@12 docker.io'
			bat 'docker push rajeshazure1980/news-group-api:latest'
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