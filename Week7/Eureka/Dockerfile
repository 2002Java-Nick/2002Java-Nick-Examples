FROM openjdk:8-jdk-alpine
COPY target/*.jar eureka.jar
ENTRYPOINT ["java", "-jar", "/eureka.jar"]
EXPOSE 8761