# -------- BUILD STAGE --------
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# -------- RUN STAGE --------
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=builder /app/target/api-gateway-1.0-SNAPSHOT.jar app.jar

EXPOSE 4003
ENV SERVER_PORT=4003
ENTRYPOINT ["java", "-jar", "app.jar"]
