
## Start Database server
Requrirement: install Docker

`cd /mini`
`docker-compose up`
## Start Backend App
Requrirement: install maven and java 21

`mvn clean install`

`mvn spring-boot:run`
## Start Frontend App
`cd /mini/frontend`

`npm install`

`npm start`
## API Overview via Swagger: 

http://localhost:8080/swagger-ui/index.html#/