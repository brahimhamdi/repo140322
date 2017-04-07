#!groovy
node {
   def mvnHome
   checkout scm

   stage('Preparation') {
      mvnHome = tool 'M3'
   }
   stage('Build') {

         sh "'${mvnHome}/bin/mvn' clean install -DskipTests -f mybatis/pom.xml"

   }

   stage('Results') {
      archive '**/target/*.jar'
   }

}