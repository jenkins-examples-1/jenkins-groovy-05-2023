def printSysTime() {
    sh(script: "echo CURRENT BRANCH: \$(git symbolic-ref HEAD) and LOCAL TIME: \$(date +%H:%M)", returnStdout: true)
}

def calculateFilesCount() {
    sh(script: "echo Files count: \$(find . -type f | wc -l)", returnStdout: true)
}

properties([
        parameters(
                [extendedChoice(name: "MODULES", value: "module-1,module-2,module-3", delimeter: ',')]
        )
])

def jibBuild(name) {
    echo "Performing dockerization and pushing to Dockerhub"

    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh(script: "./gradlew -p ${name} jib -Djib.to.auth.username=${USERNAME} -Djib.to.auth.password=${PASSWORD}", returnStdout: true)
    }
}

ArrayList moduleToFolder = [

]

def checkout(name) {
    git branch: name, credentialsId: 'github', url: 'git@github.com'

}

node {
    stage('clean workspace') {
        cleanWs()
    }

    stage('parallel git checkout') { m ->
        def branchtages = [:]
        params.MODULES.split(',').each {
            branchtages[m] = {
                stage("Parallel git checkout: ${m}") {
                    dir("${WORKSPACE}/${m}") {
                        checkout(m)
                    }
                }
            }
        }
        parallel branchtages
    }
}
