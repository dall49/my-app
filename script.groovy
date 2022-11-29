def buildJar() {
     echo 'building Jar file...'
     sh 'mvn package'
}

def buildImg() {
     echo 'building docker image..'
     withCredential([usernamePassword(credentialsId:'dockerhub-rep', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t dockerysf/my-app:3.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push dockerysf/my-app:3.0'
     }
}

/*def testApp() {
     echo 'testing app...'
}*/

def deployApp() {
     echo 'deploying app...'
     // echo "deploying version ${params.VERSION}"
}

return this
