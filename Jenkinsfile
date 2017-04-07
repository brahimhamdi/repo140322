#!groovy
node {
   def mvnHome
   checkout scm

   stage('Preparation') {
      mvnHome = tool 'M3'
      ansible = tool 'ANS'
   }
   stage('Build') {

         sh "'${mvnHome}/bin/mvn' clean install  -f mybatis/pom.xml"

   }

   stage('Results') {
      archive '**/target/*.jar'
   }

}