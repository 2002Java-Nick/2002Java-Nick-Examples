FROM openjdk:8-jdk-alpine
COPY target/*.jar car-service.jar
ENTRYPOINT ["java", "-jar", "/car-service.jar"]
EXPOSE 8082