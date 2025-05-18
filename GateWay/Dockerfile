# Step 1: Use the official OpenJDK 17 base image 
FROM openjdk:17-jdk-slim

# Step 2: Install curl
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Step 3: Set the working directory in the container
WORKDIR /app

# Step 4: Copy the Maven built JAR file into the container
COPY target/GateWay-0.0.1-SNAPSHOT.jar /app/GateWay.jar

# Step 5: Expose the port your Spring Boot application will run on
EXPOSE 8090

# Step 6: Define the command to run the application
CMD ["java", "-jar", "/app/GateWay.jar"]
