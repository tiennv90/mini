## Tech stack
⚛️ ![React](https://img.shields.io/badge/React-JS-61DAFB?logo=react&logoColor=white) React JS |
⚡ ![Next.js](https://img.shields.io/badge/Next-JS-black?logo=next.js) Next JS |
☕ ![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=java&logoColor=white) Java 21 |
🗄 ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql&logoColor=white) PostgreSQL |
🚀 ![Redis](https://img.shields.io/badge/Redis-DC382D?logo=redis&logoColor=white) Redis |
📡 ![Kafka](https://img.shields.io/badge/Kafka-000000?logo=apachekafka&logoColor=white) Kafka
## Start Database servers
Requirement: install Docker

`cd /mini/backend-boostrap/order-bootstrap`

`cd /mini/backend-boostrap/parcel-bootstrap`

`cd /mini/backend-boostrap/shipment-bootstrap`

`docker-compose up`
## Start Backend App
Requirement: install maven and java 25

`mvn clean install`

`mvn spring-boot:run`

## Start monitoring servers

`cd /mini/devops/monitoring`
`docker-compose up`

## Start Kafka servers

`cd /mini/kafka`
`docker-compose up`

## API Overview via Swagger: 

http://localhost:8080/swagger-ui/index.html#/

## CLI commands
### Access Redis server local

`redis-cli -u redis://127.0.0.1:6379`

## features
### Completed
#### Implement microservices
#### Split the source code to microservices
#### Implement RateLimiter in order service
#### Implement REDIS cache in order service
#### Implement Circuit Breaker in order service
#### Redesign create order flow: order -> KAFKA -> create shipment
#### Implemented  monitoring tools

### Planned

#### Re-design frontend
#### Implement Event bus to support Microservices and KAFKA
#### Remove shared modules
#### KAFKA message handling with queue to process the queue orderly
#### KAFKA Replay
#### Implement placeholder objects to support no return data/error from external service call.
#### KUBERNETES: Implement INGRESS controller as API GATEWAY
#### KUBERNETES: Implement  Deployment scripts
#### KUBERNETES: Implement POD Readiness, Graceful shutdown, Load Balancer 
#### Apply reactive to implement user click service
#### Import orders from big CSV files
#### Concurrency: CPU intensive consuming task, compress order and parcel documents and aggregate results. (Fork and Join)
#### Fire and forget to send log to message broker
#### Concurrency options: Executors, Virtual Thread, Future, CompletableFuture Aggregate), @Async, ComposeAsync, CombineAsync

