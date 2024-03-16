FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /RentNest
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY --from=build /RentNest/target/RentNest.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]