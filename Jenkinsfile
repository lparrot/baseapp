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

  stage("deploy") {
      sh 'mvn -s /etc/maven/settings.xml clean'
	  	sh 'mvn -s /etc/maven/settings.xml deploy -Dmaven.test.skip=true'
  }
  
}