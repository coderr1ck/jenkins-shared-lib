def call(){
	sh 'trivy fs . -o scan.json'
}
