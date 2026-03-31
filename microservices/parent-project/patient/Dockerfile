FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/patient-service-1.0-SNAPSHOT.jar app.jar

EXPOSE 4000

ENTRYPOINT ["java","-jar","app.jar"]