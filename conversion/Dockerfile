FROM java:8-jre

WORKDIR usr/src

ADD ./target/conversion-0.0.1-SNAPSHOT.jar /usr/src/conversion-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","conversion-0.0.1-SNAPSHOT.jar"]