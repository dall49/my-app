node{

    stage("SCM Checkout"){
        git credentialsId: 'git-credentials', url: 'https://github.com/dall49/my-app.git'
    }
    
    stage("MVN package"){
        def mvnHome = tool name: 'maven-tool', type: 'maven'
        def mvnCMD = "${mvnHome}/bin/mvn"
        sh "${mvnCMD} clean package"
    }

    stage("Build Docker Image"){
        sh "docker build -t dall49/my-app:1.1.0 ."
    }

    stage("Push Docker Image"){
        withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
            sh "docker login -u dall49 -p ${dockerHubPwd}"
        }
        sh "docker push dall49/my-app:1.1.0"
    }
    
    stage("Run Container on Dev Server"){
        sh "docker run -d -p 8081:8080 --name my-app-v2 dall49/my-app:1.1.0"
    }
    
}
