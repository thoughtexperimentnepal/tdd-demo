@Library(['github.com/abnamrocoesd/jenkins-pipeline-library']) _
pipeline {
    agent { label 'docker' }
    options {
        timeout(time: 60, unit: 'MINUTES')
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '5'))
    }
    stages {
        stage('Checkout') {
            steps {
                deleteDir()
                git 'your amazing git project'
            }
        }
        stage('Prepare Workspace') {
            steps {
                notifyAtomist("UNSTABLE", "STARTED")
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
    post {
        success {
            echo "SUCCESS"
        }
        unstable {
            echo "UNSTABLE"
        }
        failure {
            echo "FAILURE"
        }
        changed {
            echo "Status Changed: [From: $currentBuild.previousBuild.result, To: $currentBuild.result]"
        }
        always {
            script {
                def result = currentBuild.result
                if (result == null) {
                    result = "SUCCESS"
                }
                notifyAtomist(result)
            }
            echo "ALWAYS"
            step([$class: 'WsCleanup', notFailBuild: true])
        }
    }
}