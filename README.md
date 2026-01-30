Auth Service – Ecommerce Microservices Platform
📌 Overview

This repository contains the Authentication & Authorization Service for a production-grade Ecommerce Microservices Architecture.

The Auth Service is responsible for:

User registration

User login

JWT-based authentication

Securing downstream services via stateless authentication

It is designed to be cloud-deployable, scalable, and production-ready, following modern Spring Boot and security best practices.

🧱 Architecture Context

This service is part of a larger Ecommerce Microservices System, where:

Each service is independently deployable

Authentication is centralized

Authorization is enforced using JWT tokens

Services communicate securely over HTTP

[ Client / Frontend ]
          |
          v
[ Auth Service ] ---> issues JWT
          |
          v
[ Other Microservices ]
(validate JWT on each request)

🛠️ Tech Stack
Category	Technology
Language	Java 17
Framework	Spring Boot 3
Security	Spring Security 6
Authentication	JWT (JSON Web Tokens)
Database	PostgreSQL
ORM	Spring Data JPA (Hibernate)
Password Hashing	BCrypt
Build Tool	Maven
Deployment	Render (Free Tier)
API Testing	Postman / cURL
🔐 Security Design

Stateless authentication using JWT

BCrypt password hashing

Spring Security Filter Chain

Custom JwtAuthFilter to validate tokens

Protected endpoints require a valid JWT

Public endpoints explicitly whitelisted

Token Flow

User registers or logs in

Auth Service generates a JWT

Client sends JWT in Authorization header

Token validated on every protected request

Authorization: Bearer <JWT_TOKEN>

📂 Project Structure
auth-service
├── controller
│   └── AuthController.java
├── service
│   └── UserService.java
├── security
│   ├── JwtUtil.java
│   ├── JwtAuthFilter.java
│   └── SecurityConfig.java
├── repository
│   └── UserRepository.java
├── entity
│   └── User.java
├── dto
│   ├── AuthRequest.java
│   └── AuthResponse.java
├── exception
│   └── GlobalExceptionHandler.java
└── application.properties

🌐 API Endpoints
🔓 Public Endpoints
Register User
POST /auth/register


Request Body

{
  "username": "john",
  "email": "john@example.com",
  "password": "Password123"
}


Response

{
  "token": "<JWT_TOKEN>",
  "message": "User registered successfully"
}

Login
POST /auth/login


Request Body

{
  "username": "john",
  "password": "Password123"
}

🔐 Protected Endpoints
Verify Authentication
GET /auth/me


Headers

Authorization: Bearer <JWT_TOKEN>


Response

You are authenticated!


❌ Without JWT → 401 Unauthorized

❗ Error Handling

The service uses a Global Exception Handler to return clean, consistent error responses.

Example: Duplicate Username
POST /auth/register


Response

{
  "timestamp": "2026-01-30T01:01:20",
  "message": "Username already exists",
  "status": 400
}


This avoids ugly stack traces and makes the API consumer-friendly.

🧪 Testing
Using Postman

Register → receive JWT

Login → receive JWT

Access /auth/me with JWT → ✅

Access /auth/me without JWT → ❌ 401

Negative Test Cases

Duplicate username → 400

Invalid password → 401

Missing JWT → 401

Tampered JWT → 403

☁️ Cloud Deployment (Render – Free Tier)
Environment Variables
DB_HOST=xxxx
DB_PORT=5432
DB_NAME=auth_db
DB_USERNAME=xxxx
DB_PASSWORD=xxxx
JWT_SECRET=superStrongSecretKey123!

Build Command
./mvnw clean package

Start Command
java -jar target/auth-service-0.0.1-SNAPSHOT.jar


Once deployed, Render provides a public HTTPS URL usable as a demo environment.

🚀 Production Readiness Checklist

✔ Stateless JWT authentication
✔ Secure password hashing
✔ Global exception handling
✔ Environment-based configuration
✔ Cloud deployable
✔ Clear API contracts
✔ Scalable microservice design

🔮 Future Enhancements

Refresh tokens

Role-based authorization (ADMIN / USER)

API Gateway integration

OAuth2 / Social login

Rate limiting

Centralized logging & monitoring

👨‍💻 Author

Built as part of a production-grade Ecommerce Microservices platform to demonstrate real-world backend architecture, security, and cloud deployment practices.
