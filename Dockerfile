FROM openjdk:17.0.2-slim-buster
WORKDIR /api
COPY target/*.jar /api/app.jar

EXPOSE 8080

CMD java -Dspring.profiles.active=prod -jar app.jar


