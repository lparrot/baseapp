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
    sh 'chmod +x mvnw'
  }

  stage("Unit Tests") {
  	echo "-=- execute unit tests -=-"
  	sh './mvnw test'
 	}

  stage("Deploy") {
  	echo "-=- clean and deploy project -=-"
	  sh './mvnw clean deploy -Dmaven.test.skip=true'
  }
  
}