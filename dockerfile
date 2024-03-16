FROM openjdk:17-jdk-slim
WORKDIR /RentNest

COPY target/RentNest.jar RentNest.jar

ENTRYPOINT ["java", "-jar", "RentNest.jar"]