FROM openjdk:17-jdk-alpine
WORKDIR /RentNest
COPY ./target/RentNest.jar RentNest.jar

ENTRYPOINT ["java", "-jar", "app.jar"]