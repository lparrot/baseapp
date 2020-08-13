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

  stage("Unit Tests") {
  	echo "-=- execute unit tests -=-"
  	sh 'mvn test'
 	}

  stage("Deploy") {
  	echo "-=- clean and deploy project -=-"
	  sh 'mvn clean deploy -Dmaven.test.skip=true'
  }
  
}