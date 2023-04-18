FROM openjdk:17-jdk-alpine
WORKDIR .
COPY build/libs/user-service.jar .
EXPOSE 8080
CMD ["java", "-jar", "user-service.jar"]