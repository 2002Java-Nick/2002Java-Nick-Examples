FROM openjdk:8-jdk-alpine
COPY target/*.jar zuul.jar
ENTRYPOINT ["java", "-jar", "/zuul.jar"]
EXPOSE 8080