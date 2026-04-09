# -------- BUILD STAGE --------
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# -------- RUN STAGE --------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=builder /app/target/auth-service-1.0-SNAPSHOT.jar app.jar

EXPOSE 4005
ENTRYPOINT ["java", "-jar", "app.jar"]
