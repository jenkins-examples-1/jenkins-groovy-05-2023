pipeline {
    agent any

    parameters {
        string(name: 'BRANCH', defaultValue: 'main', description: 'branch')
    }

    tools {
        maven 'M3'
    }

    stages {
        stage('Git clone') {
            steps {
                git branch: params.BRANCH, url: 'https://github.com/a-poliakov/common-libs.git'
            }
        }

        stage('Test common libraries') {
            steps {
                sh "mvn test compile"
            }
        }

        stage('Build common libs') {
            steps {
                git branch: params.BRANCH, url: 'https://github.com/a-poliakov/common-libs.git'
//                sh "git checkout ${params.BRAnCH}"
                sh "mvn clean package -Dskip.tests=true"
            }
        }

        stage("build deploy target") {
            parallel {
                stage("streaming") {
                    stages {
                        stage('Build streaming') {
                            steps {
                                git branch: params.BRANCH, url: 'https://github.com/a-poliakov/streaming.git'
                                sh "mvn clean package"
                            }
                        }

                        stage('Deploy streaming') {
                            steps {
                                script {
                                    project_version = sh script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true
                                    echo project_version
                                }

                                sh  """
                                   curl -i -X PUT "http://namenode:9870/webhdfs/v1/streaming_${params.BRANCH}/common-libs-${project_version}.jar?op=CREATE&overwrite=true"
                                   curl -i -X PUT -T test_jenkins_mvn-1.0-SNAPSHOT.jar "http://datanode:9864/webhdfs/v1/streaming_${params.BRANCH}/common-libs-${project_version}.jar?op=CREATE&namenoderpcaddress=namenode:9000&createflag=&createparent=true&overwrite=true" 
"""
                            }
                        }
                    }
                }

                stage("batch") {
                    stages {
                        stage('Build streaming') {
                            steps {
                                git branch: params.BRANCH, url: 'https://github.com/a-poliakov/streaming.git'
                                sh "mvn clean package"
                            }
                        }

                        stage('Deploy streaming') {
                            steps {
                                script {
                                    project_version = sh script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true
                                    echo project_version
                                }

                                sh  """
                                   curl -i -X PUT "http://namenode:9870/webhdfs/v1/streaming_${params.BRANCH}/common-libs-${project_version}.jar?op=CREATE&overwrite=true"
                                   curl -i -X PUT -T test_jenkins_mvn-1.0-SNAPSHOT.jar "http://datanode:9864/webhdfs/v1/streaming_${params.BRANCH}/common-libs-${project_version}.jar?op=CREATE&namenoderpcaddress=namenode:9000&createflag=&createparent=true&overwrite=true" 
"""
                            }
                        }
                    }
                }

                stage("rest") {
                    stages {
                        stage('Build streaming') {
                            steps {
                                git branch: params.BRANCH, url: 'https://github.com/a-poliakov/streaming.git'
                                sh "mvn clean package"
                            }
                        }

                        stage('Deploy streaming') {
                            steps {
                                script {
                                    project_version = sh script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true
                                    echo project_version
                                }

                                sh  """
                                   curl -i -X PUT "http://namenode:9870/webhdfs/v1/streaming_${params.BRANCH}/common-libs-${project_version}.jar?op=CREATE&overwrite=true"
                                   curl -i -X PUT -T test_jenkins_mvn-1.0-SNAPSHOT.jar "http://datanode:9864/webhdfs/v1/streaming_${params.BRANCH}/common-libs-${project_version}.jar?op=CREATE&namenoderpcaddress=namenode:9000&createflag=&createparent=true&overwrite=true" 
"""
                            }
                        }
                    }
                }
            }
        }
    }
}
