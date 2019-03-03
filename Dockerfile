# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="stratilat19@yahoo.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/SpringMvcDemo-1.0-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} SpringMvcDemo.jar

# Add nodejs
RUN apk add nodejs

# Run the jar file
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SpringMvcDemo.jar"]
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/SpringMvcDemo.jar"]
