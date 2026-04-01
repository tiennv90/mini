
## Start Database server
Requrirement: install Docker

`cd /mini`
`docker-compose up`
## Start Backend App
Requrirement: install maven and java 21

`mvn clean install`

`mvn spring-boot:run`

http://localhost:8080/

## Start Frontend App

`cd /mini/frontend`

`npm install`

`npm start`

http://localhost:3000

## API Overview via Swagger: 

http://localhost:8080/swagger-ui/index.html#/

## New features
### Microservices use cases
#### Implement Event bus to support microservice and kafka
#### Split the source code to micro services
### Concurrency use cases
#### Kafka message handling with queue to process the queue orderly
#### CPU intensive consuming task, compress order and parcel documents and aggregate results. (Fork and Join)
#### Fire and forget to send log to message broker
#### Concurrency options: Executors, Virtual Thread, Future, CompletableFuture Aggregate), @Async, ComposeAsync, CombineAsync
#### Apply reactive to implement user click service
#### Resource 1: https://www.youtube.com/watch?v=vhHDlSV_0zg
#### Resource 2:https://www.youtube.com/watch?v=lnSn2rxSlKo