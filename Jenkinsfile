pipeline {
  agent any
  options {
    // Stop the build early in case of compile or test failures
    skipStagesAfterUnstable()
  }
  stages {
    stage('Clean and build') {
    //  steps {
        // Compile the app and its dependencies
         parallel {
         stage('Clean and build')
         {
           steps
           {
            bat './gradlew clean'
            bat './gradlew assembleDebug'
            }
         }

        }
     // }
    }
    stage('Unit test') {
      steps {
        // Compile and run the unit tests for the app and its dependencies
        bat './gradlew testDebugUnitTest jacocoTestReport'

        // Analyse the test results and update the build result as appropriate
        junit '**/build/test-results/**/TEST-*.xml'
        jacoco(classPattern: '**/tmp/kotlin-classes/debug/*-classes', sourceExclusionPattern: '**/R.class,**/R$*.class,**/*$ViewInjector*.*,**/*$ViewBinder*.*,**/BuildConfig.*,**/Manifest*.*,**/*$Lambda$*.*,**/*Module.*,**/*Dagger*.*,**/*MembersInjector*.*,**/*_Provide*Factory*.*,**/*_Factory*.*,**/*$*$*.*', sourceInclusionPattern: '/src/main/kotlin')

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

     stage('Deploy') {
          when {
            // Only execute this stage when building from the `beta` branch
            branch 'master'
          }

          environment {
            // Assuming a file credential has been added to Jenkins, with the ID 'my-app-signing-keystore',
            // this will export an environment variable during the build, pointing to the absolute path of
            // the stored Android keystore file.  When the build ends, the temporarily file will be removed.
            SIGNING_KEYSTORE = 'certificate/unitestdemo.jks'

            // Similarly, the value of this variable will be a password stored by the Credentials Plugin
            SIGNING_KEY_PASSWORD = '123456'

          }

          steps {
            // Build the app in release mode, and sign the APK using the environment variables
            bat './gradlew assembleRelease'

            // Archive the APKs so that they can be downloaded from Jenkins
            archiveArtifacts '**/*.apk'

          }

        }

  }

}

