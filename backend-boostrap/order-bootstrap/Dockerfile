FROM openjdk:25-ea-21-jdk-slim AS builder

COPY target/order-bootstrap-1.0.jar /

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "order-bootstrap-1.0.jar"]