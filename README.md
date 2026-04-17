
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

## CLI commands
### Access Redis server local

`redis-cli -u redis://127.0.0.1:6379`
