FROM adoptopenjdk:17-jdk-hotspot

WORKDIR /RentNest

COPY target/RentNest.jar app.jar

ENTRYPOINT ["java", "-jar", "RentNest.jar"]