FROM openjdk:17-alpine
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","RentNest.jar"]
EXPOSE 8080
