# syntax=docker/dockerfile:1
FROM maven:3.9.16-eclipse-temurin-25-alpine AS builder

WORKDIR /app

COPY pom.xml .
COPY backend-boostrap ./backend-boostrap
COPY backend-modules ./backend-modules

#build modules
RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package

FROM eclipse-temurin:25.0.3_9-jdk-alpine AS runner

#Create non-root user, user id below 10000 reserved for system users
RUN addgroup -g 10001 -S appgroup && \
    adduser -u 10001 -S appuser -G appgroup

WORKDIR /app

COPY --chown=appuser:appgroup \
    --from=builder \
    /app/backend-boostrap/order-bootstrap/target/order-bootstrap-1.0.jar /app/order-bootstrap-1.0.jar

USER appuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "order-bootstrap-1.0.jar"]