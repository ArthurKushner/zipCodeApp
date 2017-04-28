# zipCodeApp

This is sample application which allows to search USA cities by zip code.

This application is built with Spring and Vaadin frameworks and MongoDb database


## Getting Started

To clone this project type the following command in terminal:
```
$ git clone https://github.com/ArthurKushner/zipCodeApp.git
```

### Prerequisites

[Java8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Docker](https://www.docker.com/community-edition)

[Gradle](https://docs.gradle.org/current/userguide/installation.html) - optional (there is a gradle wrapper in project)


### Installing

To compile application you need to run gradle task 'build'
If you have gradle tool installed on your compoter then run the following command from the project root folder:

```
$ gradle build
```

If you don't have gradle installed or have incompatible version of it you can use gradle wrapper from project.
To run gradle task with wrapper you should run shell script 'gredlew' from the project root folder:

```
$ ./gradlew build
```

After compiling project with gradle you can find executable jar file in
```
/${projectDir}/application-service/build/libs/application-service.jar
```

## Deployment

To start application you should type the following command in terminal from the project root folder:
```
$ docker-compose up
```
- it will launch containers for SpringBootApplication and for MongoDB database.

It will take several minutes to start application for the first time, because docker needs to download base containers images.
All further deployments will take less time.

After applpication deployment you can access it throw browser:
```
http://localhost:8080/
```


## Built With

* [Spring](https://spring.io/projects) - Java framework
* [Vaadin](https://vaadin.com/home) - Java framework for Web Applications
* [Gradle](https://gradle.com/enterprise) - Dependency Management
* [MongoDB](https://www.mongodb.com/) - NoSQL database
* [Docker](https://www.docker.com/) - Software container platform


## Authors

* **Arthur Kushner** 


## Help

If you have any questions or need help with installation and deployment feel free to contact:
```
e-mail: 4car.by@gmail.com

skype: stail08
```

