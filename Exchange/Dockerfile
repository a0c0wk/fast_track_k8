FROM java:8-jre

WORKDIR usr/src

ADD ./target/Exchange-0.0.1-SNAPSHOT.jar /usr/src/Exchange.jar

ENTRYPOINT ["java","-jar","Exchange.jar"]