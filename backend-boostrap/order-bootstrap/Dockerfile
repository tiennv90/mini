FROM eclipse-temurin:25.0.3_9-jdk-alpine AS builder

COPY target/order-bootstrap-1.0.jar /

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "order-bootstrap-1.0.jar"]