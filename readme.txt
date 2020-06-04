
# Application URL

#Exchange
	# http://localhost:8181/exchange/feign/USD/10000
	# http://localhost:8181/exchange/resteureka/CAD/10000

# conversion svc 
	#http://localhost:8081/conversion/factor/CAD
	#http://localhost:8081/conversion/details/USD

#Zipkin URL   http://localhost:9411/zipkin     C:\Users\AmitJain>java -jar zipkin.jar
	#docker run -d -p 9411:9411 openzipkin/zipkin

#Eureka  URl  http://localhost:8761/

#ZuulProxy
  	#http://localhost:8765 --> http://localhost:8765/{applicationname}/{appuri} 

	#http://localhost:8765/conversion-service/conversion/factor/CAD
	#http://localhost:8765/exchange-service/exchange/feign/USD/10000


