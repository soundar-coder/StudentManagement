
📘 Student Management System (CRUD)
Spring Boot + MySQL + Spring Security (Custom UserDetailsService)

This project is a simple and secure Student CRUD Application built using Spring Boot, MySQL, and Spring Security 6.
It demonstrates form authentication, custom user loading, and role-based access to API endpoints.

🚀 Features

🔐 User Authentication (Spring Security 6)

👨‍🎓 Complete Student CRUD Operations

💾 MySQL Database Integration

🎯 Custom UserDetailsService Implementation

🧩 Spring Data JPA for Database Access

🛠️ Tech Stack

Java 17

Spring Boot 3+

Spring Security 6

Spring Data JPA

MySQL

Maven

📂 Project Structure
src/main/java/com/example/demo
│
├── controller
├── service
│   ├── StudentService
│   └── CustomUserDetailsService
├── repository
├── entity
└── security

🔐 Security Overview

/home → Public

/ → Public

/api/** → Requires Authentication

Custom user loading:

@Override
public UserDetails loadUserByUsername(String username) {
    StudentEntity se = studRepo.findByUsername(username);
    return new User(se.getUsername(), se.getPassword(), Collections.emptyList());
}

🗄️ Database Configuration
Create database:
CREATE DATABASE student_entity;

Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/student_entity
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

▶️ Running the Application

Use the following command:

mvn spring-boot:run


App will start at:

http://localhost:8080->runs only on localhost not over internet

 API Endpoints
🔓 Public
Method	Endpoint	Description
GET	/home	Public Home Page
 Protected (Requires Login)
Method	Endpoint	Description
POST	/api/student	Add Student
GET	/api/student/{id}	Get Student by ID
GET	/api/student	Get All Students
PUT	/api/student/{id}	Update Student
DELETE	/api/student/{id}	Delete Student
 How Authentication Works

User enters username & password

Spring Security calls CustomUserDetailsService

Password is compared using PasswordEncoder

If correct → user gets access to /api/** routes
