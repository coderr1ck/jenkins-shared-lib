def call(String builtImageName, String credentialId, String imageTag, String toPushImageName) {
    withCredentials([usernamePassword(credentialsId: credentialId, 
                                      usernameVariable: 'DOCKERHUB_USER', 
                                      passwordVariable: 'DOCKERHUB_PASS')]) {
        
        // Execute the shell steps using the populated credentials
        sh "echo '${DOCKERHUB_PASS}' | docker login -u '${DOCKERHUB_USER}' --password-stdin"
        sh "docker image tag ${builtImageName}:${imageTag} '${DOCKERHUB_USER}/${toPushImageName}:${imageTag}'"
        sh "docker push '${DOCKERHUB_USER}/${toPushImageName}:${imageTag}'"
    }
}

