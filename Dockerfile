# ===== Stage 1: Build =====
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven wrapper and POM first
COPY mvnw mvnw.cmd pom.xml ./
COPY .mvn .mvn

# Make wrapper executable
RUN chmod +x mvnw

# Copy source code
COPY src ./src

# Build jar (skip tests, batch mode)
RUN ./mvnw clean package -DskipTests -B

# ===== Stage 2: Runtime =====
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8081

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
