
## Start Database servers
Requrirement: install Docker

`cd /mini/backend-boostrap/order-bootstrap`
`cd /mini/backend-boostrap/parcel-bootstrap`
`cd /mini/backend-boostrap/shipment-bootstrap`
`docker-compose up`
## Start Backend App
Requrirement: install maven and java 25

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

## New features
### Completed
#### Implement microservices
#### Split the source code to microservices
#### Implement RateLimiter in order service
#### Implement REDIS cache in order service
#### Redesign create order flow: order -> KAFKA -> create shipment
#### Implemented Performance monitoring tools

### Planned

#### Implement Circuit Breaker in Java
#### Implement Event bus to support Microservices and KAFKA
#### KAFKA message handling with queue to process the queue orderly
#### KAFKA Replay https://www.youtube.com/watch?v=eDk1tr7CxAQ
#### Implement placeholder objects to support no return data/error from external service call.
#### KUBERNETES: Implement INGRESS controller as API GATEWAY
#### KUBERNETES: Implement  Deployment scripts
#### KUBERNETES: Implement POD Readiness, Graceful shutdown, Load Balancer 
#### Apply reactive to implement user click service
#### Import orders from big CSV files
#### Concurrency: CPU intensive consuming task, compress order and parcel documents and aggregate results. (Fork and Join)
#### Fire and forget to send log to message broker
#### Concurrency options: Executors, Virtual Thread, Future, CompletableFuture Aggregate), @Async, ComposeAsync, CombineAsync
