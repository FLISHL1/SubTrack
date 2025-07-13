# Build stage - используем официальный образ Maven с тегом Eclipse Temurin
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Build application
COPY src src
RUN mvn package -DskipTests

# Final image - используем alpine-образ для уменьшения размера
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy entrypoint script
COPY docker-entrypoint.sh /app/
RUN chmod +x docker-entrypoint.sh

# Copy built JAR
COPY --from=builder /app/target/*.jar app.jar

# Environment variables
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75"
EXPOSE 5440

# Use entrypoint script
ENTRYPOINT ["./docker-entrypoint.sh"]