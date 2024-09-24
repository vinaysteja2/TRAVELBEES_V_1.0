# Step 1: Use the official OpenJDK 17 base image 
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the Maven built JAR file into the container
COPY target/TouristGuide-0.0.1-SNAPSHOT.jar /app/TouristGuide.jar

# Step 4: Expose the port your Spring Boot application will run on
EXPOSE 8088

# Step 5: Define the command to run the application
CMD ["java", "-jar", "/app/TouristGuide.jar"]
