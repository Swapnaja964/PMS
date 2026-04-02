# -------- RUN STAGE --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY target/billing-service-3.2.5.jar app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]