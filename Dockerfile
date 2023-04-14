# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Set environment variable for database connection
ENV DB_URL=jdbc:mariadb://db:3306/assertivaDB
ENV DB_USERNAME=root
ENV DB_PASSWORD=

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "teste-assetiva.jar"]
