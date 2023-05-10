# jenkins-groovy-05-2023

## По Jenkins:

docker-compose up -d

1) Jenkins
   http://localhost:8080/
   login: user
   password: bitnami
   
Plugins:
* Caffeine API
* Script Security
* Jakarta Activation API
* Jakarta Mail API
* Display URL API
* Mailer
* SCM API
* Pipeline: API
* Pipeline: Supporting APIs
* Git client
* Pipeline: SCM Step
* Git
* Ionicons API
* Pipeline: Job
* Pipeline: Groovy
* Pipeline: Nodes and Processes
* Folders
* Branch API
* Pipeline: Basic Steps
* Pipeline: Stage Step
* Pipeline: Multibranch
* Pipeline: Input Step
* Pipeline: Build Step
* Pipeline: Model API
* Pipeline: Milestone Step
* Pipeline: Declarative Extension Points API	 
* Variant
* Pipeline: Groovy Libraries
* Pipeline: Stage Tags Metadata
* Pipeline: Declarative
* Pipeline Graph Analysis
* Pipeline: REST API
* Pipeline: Stage View
* Pipeline
* Oracle Java SE Development Kit Installer
* OkHttp
* GitHub API
* GitHub	 


*Blue Ocean plugins:*
* Design Language	 
* Blue Ocean Core JS	 
* Java JSON Web Token (JJWT)	 
* GitHub Branch Source	 
* Common API for Blue Ocean	 
* REST API for Blue Ocean	 
* Pub-Sub "light" Bus	 
* Pipeline SCM API for Blue Ocean	 
* commons-text API	 
* Plugin Utilities API	 
* Font Awesome API	 
* Popper.js 2 API	 
* Bootstrap 5 API	 
* JQuery3 API	 
* ECharts API	 
* Checks API	 
* JUnit	 
* Matrix Project	 
* HTML Publisher	 
* Web for Blue Ocean	 
* JWT for Blue Ocean	 
* Favorite	 
* REST Implementation for Blue Ocean	 
* Pipeline implementation for Blue Ocean	 
* GitHub Pipeline for Blue Ocean	 
* Git Pipeline for Blue Ocean	 
* Config API for Blue Ocean	 
* Handy Uri Templates 2.x API	 
* Bitbucket Branch Source	 
* Bitbucket Pipeline for Blue Ocean	 
* Dashboard for Blue Ocean	 
* Personalization for Blue Ocean	 
* Display URL for Blue Ocean	 
* Server Sent Events (SSE) Gateway	 
* Events API for Blue Ocean	 
* Blue Ocean Pipeline Editor	 
* i18n for Blue Ocean	 
* Blue Ocean	 
* Common API for Blue Ocean	 
* REST API for Blue Ocean	 
* Design Language	 
* Blue Ocean Core JS	 
* Web for Blue Ocean	 
* JWT for Blue Ocean	 
* Pipeline SCM API for Blue Ocean	 
* REST Implementation for Blue Ocean	 
* Pipeline implementation for Blue Ocean	 
* Dashboard for Blue Ocean	 
* Git Pipeline for Blue Ocean	 
* GitHub Pipeline for Blue Ocean	 
* i18n for Blue Ocean	 
* Display URL for Blue Ocean	 
* Personalization for Blue Ocean	 
* Config API for Blue Ocean	 
* Blue Ocean Pipeline Editor	 
* Bitbucket Pipeline for Blue Ocean	 
* Events API for Blue Ocean	 
* Autofavorite for Blue Ocean	 
* Jersey 2 API	 
* Jira	 
* JIRA Integration for Blue Ocean	 

https://plugins.jenkins.io/docker-slaves/

curl -i -X PUT "http://namenode:9870/webhdfs/v1/deployed/test_jenkins_mvn-1.0-SNAPSHOT.jar?op=CREATE&overwrite=true"

curl -i -X PUT -T test_jenkins_mvn-1.0-SNAPSHOT.jar "http://datanode:9864/webhdfs/v1/deployed/test_jenkins_mvn-1.0-SNAPSHOT.jar?op=CREATE&namenoderpcaddress=namenode:9000&createflag=&createparent=true&overwrite=true"

