# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file to the container
COPY target/teste-assertiva-0.0.1.jar /app/teste-assertiva.jar

# Copy the SQL script to the container
COPY initdb/data.sql /docker-entrypoint-initdb.d/

# Set environment variable for database connection
ENV DB_URL=jdbc:mariadb://db:3306/assertivaDB
ENV DB_USERNAME=root
ENV DB_PASSWORD=""

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "/app/teste-assertiva.jar"]
