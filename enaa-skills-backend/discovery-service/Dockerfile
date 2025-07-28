# Stage 1: Build the application
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies to a separate layer for caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final, small image
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose the default port for a Eureka server
EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]