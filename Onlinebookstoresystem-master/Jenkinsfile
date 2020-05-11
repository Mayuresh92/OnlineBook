pipeline{
    
    agent any
    stages{
        
        stage('Compile stage'){
            
            steps{
            
            bat 'mvn -f Onlinebookstoresystem-master/pom.xml install'
            }

            }
        
         stage('Test Stage'){
        steps{
            script{
                try{
                    bat 'mvn -f Onlinebookstore/pom.xml install'
                }catch(err){
                    echo err.getMessage()
                }
        }

        }
      }
        
   stage('Sonar analysis'){
            steps{
                 script {        
                     withSonarQubeEnv('Sonar'){   
                        
                            bat 'mvn -f Onlinebookstore/pom.xml sonar:sonar -Dsonar.login=admin -Dsonar.password=admin'
                     
                     }
            }
        }
        }    
        
        stage("Quality Gate"){
            steps{
                script{
               timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
                   try{
            def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                    else
                    {
                     mail bcc: '', body: '''Build success as unit test cases  pass  criteria got matched''',
                    cc: '', from: '', replyTo: '', subject: 'Jenkins job', to: 'marathemayuresh92@gmail.com'
                    }
                       
                   }catch(err){
                       echo err.getMessage()
                        mail bcc: '', body: '''Welcome to jenkins email alert, Unit test cases passing criteria not matched with required one''',
                        cc: '', from: '', replyTo: '', subject: 'About latest Jenkins job', to: 'marathemayuresh92@gmail.com'
               }
                       
                }
            }
        }
        }
        
    }
}   
