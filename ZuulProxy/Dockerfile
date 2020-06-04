FROM java:8-jre

WORKDIR usr/src

ADD ./target/ZuulProxy-0.0.1-SNAPSHOT.jar /usr/src/ZuulProxy.jar

ENTRYPOINT ["java","-jar","ZuulProxy.jar"]