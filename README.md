# MVC-Spring-Boot

A project for the module to Java Backend forBEDU &amp; HSBC Tech Academy

## Table of Contents
1. [Technologies](#technologies)
2. [Installation](#installation)
3. [Use (proyecto2)](#usage)
4. [Use (JMS-Controller)](#usage2)
5. [Author](#author)

<a name="technologies"></a>
## 1. Technologies

* [Java](https://docs.oracle.com/en/java/)
* [Maven](https://maven.apache.org/guides/)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [PostgreSQL](https://www.postgresql.org/docs/)
* [RabbitMQ](https://www.rabbitmq.com/documentation.html)
* [Docker](https://docs.docker.com/)
* [Lombok](https://projectlombok.org/features/)
* [OpenPDF](https://github.com/LibrePDF/OpenPDF)
* [Git](https://git-scm.com/)


<a name="installation"></a>
## 2. Installation and run instructions
Create a new folder and clone the repository.
Opend the terminal and type:
```bash
    git clone https://github.com/antoniomd-fi/MVC-Spring-Boot
```
In the terminal type:
```bash
    docker-compose up
```
Run both projects on IDE or terminal
```bash
    proyecto2
    JMS-Consumer
```

<a name="usage"></a>
## 3. Use Proyecto 2

**CRUD Example**


This example is on **persona** table

**CREATE**
<img width="1100" alt="Create a Register" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/createRegister.png">

**GET ALL**
<img width="1100" alt="Get all the registers" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/getAll.png">

**GET BY ID**
<img width="1100" alt="Get a reguster by id" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/getById.png">

**UPDATE REGISTER**
<img width="1100" alt="Get a reguster by id" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/updateRegister.png">

**DELETE REGISTER**
<img width="1100" alt="Get a reguster by id" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/deleteRegister.png">

**SEND LIST**

This endpoint send a message from producer **(Proyecto 2)** to consumer **(JMS-Consumer)** through the **RabbitMQ**
<img width="1100" alt="Get a reguster by id" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/sendList.png">

<a name="usage2"></a>
## 4. Use JMS-Controller

**CREATE PDF REPORT**

The consumer **JMS-Consumer** in port **4200** automatically receive the message and with this endopoint create a report with all the sent users

<img width="1100" alt="Get a reguster by id" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/createPDF.png">
<img width="500" height="500" alt="Get a reguster by id" src="https://github.com/antoniomd-fi/MVC-Spring-Boot/blob/main/readmeAssets/download.png">

<a name="author"></a>
## 5. Author

- [Antonio Martin](https://github.com/antoniomd-fi)
