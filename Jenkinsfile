pipeline {
	agent any // run on any machine

    tools {
		// softwares needs in build
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {
		stage('Checkout Code') {
			steps {
				// download code from git Repo
                echo 'Checking out code...'
                checkout scm
            }
        }
        stage('Build & Test') {
			steps {
				// run command tools compile
                echo 'Building the application...'
                sh './mvnw clean package'
            }
        }
        stage('Archive Artifact') {
			steps {
				// find the built .jar file
                echo 'Archiving the artifact...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}