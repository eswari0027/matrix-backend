# ===== Stage 1: Build =====
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven wrapper and POM first (cache dependencies)
COPY mvnw mvnw.cmd pom.xml ./
COPY .mvn .mvn

# Make wrapper executable
RUN chmod +x mvnw

# Optional: copy settings.xml if you have mirrors
# COPY settings.xml /root/.m2/settings.xml

# Download dependencies only (speed up rebuilds)
RUN ./mvnw dependency:resolve

# Copy source code
COPY src ./src

# Build jar (skip tests to save time)
RUN ./mvnw clean package -DskipTests

# ===== Stage 2: Runtime =====
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built jar from previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8081 (Spring Boot app)
EXPOSE 8081

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
