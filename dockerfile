FROM openjdk:17-jdk-slim
WORKDIR /RentNest

COPY target/RentNest.jar app.jar

ENTRYPOINT ["java", "-jar", "RentNest.jar"]