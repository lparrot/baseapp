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

  stage("checkout") {
    deleteDir()
    checkout scm
  }

  stage("unitTest") {
 	}

  stage("clean") {
      sh 'mvn clean'
  }

  stage("deploy") {
	  	sh 'mvn deploy -Dmaven.test.skip=true'
  }
  
}