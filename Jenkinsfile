pipeline {
   agent any


   stages {
      stage(‘Build’) {
         steps {
            sh ‘gradle clean compileJava’
            sh ‘./gradlew clean build’
         }
      }
      stage(‘Deploy’){
                 steps{
                     sh ‘cf push account-address -p ./build/libs/accounts-address-0.0.1-SNAPSHOT.jar --no-start’
                 }
      }
   }
}
