# Start from a base image with Java runtime
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy the built jar from the build context
COPY build/libs/*.jar app.jar

# Set the entry point to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
