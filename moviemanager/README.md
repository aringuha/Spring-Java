### Java Web Services and RESTful API with Spring Boot for Movie

### What you'll need
- [Java](https://www.java.com) 1.8
- [Spring Boot](http://spring.io/projects/spring-boot) 2.1.2
- [maven](https://maven.apache.org/)
- JPA/Hibernate
- [H2](http://www.h2database.com)
- DevTools
- [Lombok](https://projectlombok.org/)
- [JUnit 4](https://junit.org/junit4/)
- [Swagger](https://swagger.io/) 2
- [Docker ]

### Build with Gradle & Run the application
```sh
$ ./gradlew build && java -jar build/libs/movieManager.jar
```

```sh
Nevigate to http://localhost:8080 to see your endpoints.
```

Database UI
http://localhost:8080/h2/

Swagger UI
http://localhost:8080/swagger-ui.html

### build with Docker & Run the application
Follow the below steps in sequence.
- To Containerize the Application, run the cmd below which will build a Docker image in the name mydocker/movieManager:latest

		$ ./gradlew build docker
	 
- Run the docker image with the below cmd
	
		$ docker run -p 8081:8080 -t mydocker/movieManager

- Nevigate to http://localhost:8081to see your your endpoints.
- Here 8081 is the Docker port and 8080 is the Tomcat port where is Spring Boot Application is running. 

