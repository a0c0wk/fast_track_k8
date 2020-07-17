
# Application URL

#Exchange
	# http://localhost:8181/exchange/feign/USD/10000
	# http://localhost:8181/exchange/resteureka/CAD/10000

# conversion svc 
	#http://localhost:8081/conversion/factor/CAD
	#http://localhost:8081/conversion/details/USD

#Zipkin URL   http://localhost:9411/zipkin   
        Running zipkin localy : C:\Users\AmitJain>java -jar zipkin.jar
	#docker run -d -p 9411:9411 openzipkin/zipkin

#Eureka  URl  http://localhost:8761/

#ZuulProxy
  	#http://localhost:8765 --> http://localhost:8765/{applicationname}/{appuri} 

	#http://localhost:8765/conversion-service/conversion/factor/CAD
	#http://localhost:8765/exchange-service/exchange/feign/USD/10000


# Docker Hub : https://hub.docker.com/

# Docker commands :
docker build -t {dockerhub id}/{docker hub repo name}:{tag name} .
docker push {dockerhub id}/{docker hub repo name}:{tag name}
note : docker hub repo name = image name

#Docker-compose
docker-compose up -d  
docker-compose down -v --rmi 

#Kubernetes command 
Kubectl create -f *.yml
Kubectl create -f conversion_deployment.yml
Kubectl replace -f conversion_deployment.yml
Kubectl apply -f conversion_deployment.yml
Kubectl apply -f conversion_service.yml
kubectl get all
kubectl get pods -o=wide
kubectl logs -f pod-name

