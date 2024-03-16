FROM openjdk:17-jdk-alpine
WORKDIR /RentNest
COPY ./target/RentNest.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]