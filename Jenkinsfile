pipeline {
  agent any
  options {
    // Stop the build early in case of compile or test failures
    skipStagesAfterUnstable()
  }
  stages {
    stage('Clean and build') {
      steps {
        // Compile the app and its dependencies
        bat './gradlew clean'
        bat './gradlew assembleDebug'
      }
    }
    stage('Unit test') {
      steps {
        // Compile and run the unit tests for the app and its dependencies
        bat './gradlew testDebugUnitTest jacocoTestReport'

        // Analyse the test results and update the build result as appropriate
        junit '**/build/test-results/**/TEST-*.xml'
      }
    }
    stage('Build APK') {
      steps {
        // Finish building and packaging the APK
        bat './gradlew assembleDebug'

        // Archive the APKs so that they can be downloaded from Jenkins
        archiveArtifacts '**/*.apk'
      }
    }

  }

}