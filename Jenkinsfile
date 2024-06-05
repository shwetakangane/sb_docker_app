pipeline{
    agent any
    tools{
        maven 'M3'
    }
    environment {
        PATH = "/usr/local/bin:${env.PATH}"
        docker_registry = credentials('dockerhubsecrets')
        KUBECONFIG_SECRET = credentials('kubeconfig-secret')
    }
    stages{
        stage('GIT CLONE'){
            steps{
                git branch: 'main', credentialsId: 'c1e138e4-4f5c-429c-a979-5a65e48a7dd9', url: 'https://github.com/shwetakangane/sb_docker_app.git'
            }
            
        }
        stage('MAVEN BUILD'){
            steps{
                script{
                    dir('/Users/shwetakangane/.jenkins/workspace/KubernetesDemo/FirstDemoApp/demo'){
                            sh 'mvn clean install' 
                    }
                }
            }
        }
        stage('DOCKER IMAGE'){
            steps{
                script{
                    dir('/Users/shwetakangane/.jenkins/workspace/KubernetesDemo/FirstDemoApp/demo'){
                        sh 'docker image rm webshweta/firstdemoapp:latest -f'
                        sh 'docker build -t webshweta/firstdemoapp:latest .' 
                    }
                }
            }
        }
        stage('PUSH IMAGE'){
            steps{
                script{
                    sh """
                        echo ${docker_registry_PSW} | docker login -u ${docker_registry_USR} --password-stdin
                    """
                    sh 'docker push webshweta/firstdemoapp:latest'
                }
            }
       }
       stage('Deploy to Kubernetes') { 
            steps {
                script{
                    dir('/Users/shwetakangane/.jenkins/workspace/KubernetesDemo/FirstDemoApp/demo'){
                        withCredentials([file(credentialsId: 'kubeconfig-secret', variable: 'KUBECONFIG')]) {
                            sh 'kubectl delete deployment firstdemoapp'
                            sh 'kubectl apply -f demo-service.yaml'
                        }
                    }
                }
            }
        }
       stage('CONFIRM DEPLOYMENT'){
           steps{
               echo 'HAPPY DEPLOYMENT WITH KUBERNETES :)'
           }
       }
    }
}