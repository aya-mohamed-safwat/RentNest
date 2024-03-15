FROM maven:3.8.3-openjdk-17 AS build
COPY . .

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/RentNest.jar /RentNest.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","RentNest.jar"]