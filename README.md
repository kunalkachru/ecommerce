# Auth Service – E-Commerce Microservices

A **production-grade Authentication & Authorization microservice** built using **Spring Boot + JWT**, designed as part of a scalable **E-Commerce Microservices Architecture**.

This service handles:
- User registration
- User login
- Password encryption
- JWT token generation & validation
- Securing APIs using Spring Security

---

## 📌 High-Level Architecture

[ Client (Web / Mobile) ]
|
v
[ Auth Service ]
|
v
[ User Database ]


- Client authenticates using `/auth/login`
- JWT token is returned
- Token must be sent in `Authorization` header for secured endpoints
- Stateless authentication using JWT

---

## 🛠 Tech Stack

| Layer            | Technology |
|------------------|------------|
| Language         | Java 17 |
| Framework        | Spring Boot 3 |
| Security         | Spring Security 6 |
| Authentication  | JWT (io.jsonwebtoken – jjwt) |
| ORM              | Spring Data JPA (Hibernate) |
| Database         | MySQL / PostgreSQL |
| Build Tool       | Maven |
| API Testing      | Postman / curl |
| Deployment Ready | Docker + Cloud |

---

## 📂 Project Structure


auth-service
├── controller
│ └── AuthController.java
├── service
│ └── UserService.java
├── security
│ ├── JwtUtil.java
│ ├── JwtAuthFilter.java
│ └── SecurityConfig.java
├── repository
│ └── UserRepository.java
├── entity
│ └── User.java
├── dto
│ ├── AuthRequest.java
│ └── AuthResponse.java
├── exception
│ └── GlobalExceptionHandler.java
└── AuthServiceApplication.java


---

## 🔐 Authentication Flow

1. User registers via `/auth/register`
2. Password is encrypted using BCrypt
3. User data stored in DB
4. JWT token is generated
5. Client sends token in every secured request

Authorization: Bearer <JWT_TOKEN>


---

## 🚀 API Endpoints

### ✅ Register User
POST /auth/register


**Request**
```json
{
  "username": "john",
  "email": "john@example.com",
  "password": "password123"
}
Response

{
  "token": "eyJhbGciOiJIUzM4NCJ9...",
  "message": "User registered successfully"
}
✅ Login User
POST /auth/login
**Request**

{
  "username": "john",
  "password": "password123"
}
Response

{
  "token": "eyJhbGciOiJIUzM4NCJ9...",
  "message": "Login successful"
}
🔒 Secured Endpoint
**Request**
GET /auth/me
Header

Authorization: Bearer <JWT_TOKEN>
Response

You are authenticated!
❌ Negative Test Scenarios
Username Already Exists
Status: 400 BAD REQUEST

{
  "timestamp": "2026-01-30T01:01:20",
  "message": "Username already exists",
  "status": 400
}
Invalid Password
Status: 401 UNAUTHORIZED

{
  "timestamp": "2026-01-30T01:05:12",
  "message": "Invalid password",
  "status": 401
}
Missing JWT Token
Status: 403 FORBIDDEN

{
  "status": 403,
  "error": "Forbidden"
}
## ⚙️ Security Configuration Highlights
CSRF disabled (JWT based)

Stateless session

Custom JWT filter

Only /auth/login and /auth/register are public

All other endpoints require authentication

.anyRequest().authenticated()

## 🌍 Deployment (Free Tier Friendly)
This service can be deployed on:

Railway

Render

Fly.io

AWS EC2 (Free Tier)

Docker (Optional)
docker build -t auth-service .
docker run -p 8082:8082 auth-service
📈 Production-Readiness Checklist
✅ JWT-based stateless authentication
✅ Encrypted passwords
✅ Global exception handling
✅ Clean layered architecture
✅ Secure endpoints
✅ Cloud-deployable
✅ GitHub-ready documentation

## 🔮 Next Roadmap
### API Gateway

### Product Service

### Order Service

### Inventory Service

### Payment Service

### Centralized Config Server

### Distributed Tracing

### CI/CD Pipeline

## 👤 Author
Built as part of a Production-Grade E-Commerce Microservices Project
using Spring Boot & Cloud-Native principles.

