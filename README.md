E-Commerce REST API — Spring Boot
Java 17 · Spring Boot 3 · Spring Security · JWT · PostgreSQL · AWS EC2
Live: ---------------------- · Swagger UI: http://<host>/swagger-ui.html

What's Built
Auth — JWT stored in HTTP-only cookies, role-based access (USER / ADMIN), full signup & login flow with custom security filter chain
Products & Categories — Full CRUD, image upload, keyword search, pagination & sorting, discount/special price support
Cart — Add, update quantity, remove items — all scoped to the logged-in user
Address — User address management, fully validated, linked to authenticated user
Orders & Payments — Checkout from cart, delivery address selection, payment gateway fields (pgName, pgPaymentId, pgStatus) persisted on order

Architecture
Controller → Service (Interface + Impl) → Repository → PostgreSQL

DTO pattern with ModelMapper — entities never leak into the API layer
Global exception handling via @RestControllerAdvice
Bean validation on all request bodies
OpenAPI 3 / Swagger docs with endpoints grouped by module


Run Locally
bashgit clone https://github.com/yourusername/sb-ecom.git
cd sb-ecom
# set DB credentials in src/main/resources/application.properties
mvn spring-boot:run

What's Next

React.js frontend (in progress)
Stripe / Razorpay payment integration
CI/CD pipeline

This project is actively developed — backend is production-complete, full-stack coming soon.

Tanjim Hossain — CS Undergraduate · Backend Developer (Java & Spring Boot)