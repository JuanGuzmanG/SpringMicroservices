# SpringMicroservices
que muestra cómo montar un ecosistema de microservicios con **Config Server**, **Eureka Server**, **API Gateway** y dos servicios de dominio (**Employee** y **Department**).

---

## 🗂️ Módulos del proyecto

| Módulo | Descripción | Puerto |
|--------|-------------|--------|
| **config-server** | Centraliza la configuración (archivos yml) de todos los servicios. | `8888` |
| **eureka-server** | Registro y descubrimiento de servicios (Service Registry). | `8761` |
| **gateway** | Punto único de entrada; expone las rutas externas y reenvía a los microservicios internos. | `8080` |
| **employee** | CRUD de empleados con persistencia en MySQL. | `8090` |
| **department** | CRUD de departamentos con persistencia en MySQL. | `9090` |

---

## ⚙️ Tecnologías principales

* Java 17
* Spring Boot
* Spring Cloud (Config, Eureka, Gateway)
* Maven
* MySQL 8
* PostgreSQL
* Lombok
* ModelMapper
---

## 📋 Requisitos previos

* JDK 17+
* Maven 3.9+ (o `./mvnw`)
* MySQL corriendo en `localhost:3306` con usuario **root/root**  
  (o ajusta credenciales en `config-repo/*.yml`)

---

## 🚀 Tests Postman
### Create Employee
![create](/results/create.PNG)

![table](/results/tableEmployee.PNG)
### Get Employee
![get](/results/getEmployee.PNG)
### Get All Employees
![getAll](/results/getEmployee.PNG)
### Get Employees by Department
![getDepartment](/results/result1.png)
