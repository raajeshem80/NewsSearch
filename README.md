# NewsSearch
## NewsSearch API with Spring Boot and Angular JS.

### Technology stack:

* Maven;
* Tomcat embedded;
* Spring Boot;
* JUnit;
* Lombock;
* Swagger OpenApi 3

## Build

Build the application:

```bash
mvn clean package
```

Build the docker image :

```bash
docker build -t news-search .
```

## Run

Run the news-search service with below command:

```bash
docker run -p 8080:8080 news-search
```

Or

Run the included docker-compose file with:

```bash
docker-compose up
```

## Swagger

### Swagger UI end point

http://localhost:8080/swagger-ui.html

![image](https://user-images.githubusercontent.com/4980747/212449815-c8db8547-7527-4e26-bd12-e9de3f286909.png)

## To Stop

Run the included docker-compose file with:

```bash
docker-compose down
```

## Postman

Execute the postman collection json from this repo

![image](https://user-images.githubusercontent.com/4980747/212453636-aa02a8e9-4236-439c-99bb-5164176c89f9.png)

## 12-factor principles

Below are the 12-factor principles

```bash
* Codebase - GitHub
* Dependencies - Maven
* Logging - ELK
* Build and Run

```

## Code Coverage

Sonar yet to implement
