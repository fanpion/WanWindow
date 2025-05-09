pipeline{
    agent any
    stages{
        stage("first"){
            steps {
                echo 'hello world'
            }
        }
        stage("run test"){
            steps {
                echo 'run test'
            }
        }
        stage("build clean"){
            steps{
                bat 'mvn clean package'
            }
        }
    }
    post{
        always{
            echo 'always say goodbay'
        }
    }
}
