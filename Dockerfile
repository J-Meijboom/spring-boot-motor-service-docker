FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar motor-service.jar
ENTRYPOINT ["java","-jar","/motor-service.jar"]
EXPOSE 8080