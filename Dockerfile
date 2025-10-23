# ===== Stage 1: Build the Spring Boot JAR =====
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy Maven wrapper & pom first
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x mvnw

# Copy source code
COPY src ./src

# Package the app (download dependencies automatically)
RUN ./mvnw clean package -DskipTests

# ===== Stage 2: Run the Spring Boot app =====
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java","-jar","app.jar"]
