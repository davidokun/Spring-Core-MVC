# Spring Core MVC

This project is an example of using Spring MVC and Java Persistence API and Hibernate.

---

## Setup

#### MySql Instance

##### 1. Create images

`cd` into {project-root}/docker/mysql and execute

`docker build -t spring-mysql .`

It will download a base image **mysql:latest** and create a custom image from it called **spring-mysql**.

##### 2. Create container

To create the actual container execute:

`docker run -d -p 3306:3306 --name mysql-server spring-mysql`

Then run `docker ps -a` to see the container, something like this.

```
CONTAINER ID        IMAGE                    COMMAND                  CREATED             STATUS                     PORTS                    NAMES
5d186595e6a2        spring-mysql             "docker-entrypoint..."   5 minutes ago       Up 5 minutes               0.0.0.0:3306->3306/tcp   mysql-server

```

##### 3. Run .sql scripts

Connect to MySql and run file `script.sql`. It'll create a **schema**, **table** and insert test data.