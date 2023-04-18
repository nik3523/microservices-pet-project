FROM openjdk:17-jdk-alpine
WORKDIR .
COPY build/libs/post-service.jar .
EXPOSE 8080
CMD ["java", "-jar", "post-service.jar"]