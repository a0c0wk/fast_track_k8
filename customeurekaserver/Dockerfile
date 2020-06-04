FROM java:8-jre

WORKDIR usr/src

EXPOSE 8761:8761

ADD ./target/customeurekaserver-0.0.1-SNAPSHOT.jar /usr/src/customeurekaserver.jar

ENTRYPOINT ["java","-jar","customeurekaserver.jar"]