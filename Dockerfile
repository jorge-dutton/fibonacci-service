FROM openjdk:11-jdk-slim
COPY target/fibonacci-service-0.0.1-SNAPSHOT.jar fibonacci-service.jar
ENTRYPOINT ["java", "-jar", "fibonacci-service.jar"]