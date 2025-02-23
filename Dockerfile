# Use the latest stable OpenJDK 21 runtime. It uses Debian
FROM openjdk:21-slim

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/SciCalcAKS-1.0-SNAPSHOT.jar /app/SciCalcAKS-1.0-SNAPSHOT.jar

# Command to run the JAR file
CMD ["java", "--enable-preview", "-jar", "SciCalcAKS-1.0-SNAPSHOT.jar"]


