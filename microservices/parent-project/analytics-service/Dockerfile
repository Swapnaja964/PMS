FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/analytics-service-1.0-SNAPSHOT.jar app.jar

EXPOSE 4002

ENTRYPOINT ["java", "-jar", "app.jar"]
