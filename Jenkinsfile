#!groovy
node {
   def mvnHome
   checkout scm

   stage('Build') {

         sh "mvn clean install -DskipTests -f mybatis/pom.xml"

   }

   stage('Results') {
      archive '**/target/*.jar'
   }

}