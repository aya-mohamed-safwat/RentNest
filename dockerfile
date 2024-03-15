FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package


FROM openjdk:17-alpine
COPY --from=build /target/RentNest-0.0.1-SNAPSHOT.jar /RentNest.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","RentNest.jar"]