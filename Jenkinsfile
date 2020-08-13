properties(
 	[
 		[
 			$class: 'BuildDiscarderProperty',
 			strategy: [$class: 'LogRotator', numToKeepStr: '10']
 		],
 		pipelineTriggers([cron("@midnight"),pollSCM('H/5 8-18 * * 1-5')])
 	]
)

node {

  stage("Checkout") {
  	echo "-=- checkout project -=-"
    deleteDir()
    checkout scm
  }

  configFileProvider(
          [configFile(fileId: "$ID_MAVEN_SETTINGS", variable: 'MAVEN_SETTINGS')]) {

/*
          stage("Unit Tests") {
            	echo "-=- execute unit tests -=-"
            	sh 'mvn -s $MAVEN_SETTINGS test'
          }
*/

					stage("Package") {
						echo "-=- package project -=-"
						sh 'mvn -s $MAVEN_SETTINGS package source:jar javadoc:jar -Dmaven.test.skip=true'
					}

					stage("Deploy") {
						echo "-=- clean and deploy project -=-"
						sh 'mvn -s $MAVEN_SETTINGS deploy -Dmaven.test.skip=true'
					}
  }
  
}