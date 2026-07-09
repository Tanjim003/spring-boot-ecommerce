# E-Commerce REST API — Spring Boot

Java 17 + · Spring Boot 3.5 · PostgreSQL · Spring Security (JWT) · Swagger / OpenAPI

This was my first backend project — built from scratch,to learn how a real Spring Boot API is actually structured, secured, and documented. It's a full e-commerce backend: users, categories, products, cart, addresses, and checkout. The habits I picked up here — layered architecture, DTOs, validation, pagination — are the same ones I carry into every backend project since.

## What's Built

**Auth** — Signup/signin/signout, BCrypt password hashing, JWT issued as both an HTTP-only cookie and a bearer token, role model (USER / SELLER / ADMIN)

**Categories** — Full CRUD, paginated and sortable

**Products** — Full CRUD, multipart image upload, search by category, search by keyword, pagination + sorting, discount % auto-calculated into a special price

**Cart** — Add, update quantity, remove items — always scoped to the logged-in user

**Addresses** — Full CRUD, linked to the authenticated user

**Orders** — Checkout from cart → delivery address → payment details, decrements product stock, clears the cart, returns a full order summary. Payment fields (`pgName`, `pgPaymentId`, `pgStatus`) are modeled on the order but not wired to a real gateway yet.

## What This Project Taught Me

This is the project where these became real skills instead of just theory:

- **REST API design** — resource-based endpoints grouped by domain, not one giant controller
- **Repository pattern** — Spring Data JPA repositories instead of hand-written queries everywhere
- **DTO pattern** — entities never cross the API boundary; ModelMapper handles Entity ↔ DTO conversion
- **Validation** — `jakarta.validation` constraints on request payloads, caught by a global exception handler and returned as structured JSON errors instead of stack traces
- **Pagination & sorting** — Spring Data `Pageable`, with page number, page size, sort field, and sort direction all client-configurable
- **JPA relationships** — modeling One-to-Many (Category → Product), Many-to-One (Product → Seller), One-to-One (Order → Payment) properly instead of flattening everything
- **Stateless authentication** — JWT instead of server sessions, with a role model I've reused since
- **File handling** — multipart image upload with generated unique filenames
- **API documentation** — wiring up Swagger/OpenAPI so every endpoint is testable without Postman

## Architecture

```
Controller → Service (Interface + Impl) → Repository → PostgreSQL
```

- DTO pattern with ModelMapper — no entity is ever returned directly from a controller
- Global exception handling via `@RestControllerAdvice` (validation errors, not-found, custom API exceptions)
- Bean validation on request bodies
- OpenAPI 3 / Swagger docs, endpoints grouped by module

## Tech Stack

- Java 21 · Spring Boot 3.5
- Spring Security — JWT (cookie + bearer token), BCrypt, stateless sessions
- Spring Data JPA — repositories, relationships, pagination
- PostgreSQL
- ModelMapper — Entity ↔ DTO conversion
- springdoc-openapi — Swagger UI
- Lombok
- Maven

## Run Locally

Requires: Java 17, Maven, PostgreSQL

```
git clone https://github.com/Tanjim003/spring-boot-ecommerce.git
cd spring-boot-ecommerce
# create a database named `ecommerce`, then set your own credentials in
# src/main/resources/application.properties
./mvnw spring-boot:run
```

App runs on `http://localhost:8080`
Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## API Endpoints

**Auth — public**
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/signup` | Register, default role USER |
| POST | `/api/auth/signin` | Login, returns JWT (cookie + token) |
| POST | `/api/auth/signout` | Clear auth cookie |
| GET | `/api/auth/user` | Current authenticated user |

**Categories & Products**
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/public/categories` | List, paginated + sorted |
| POST | `/api/public/categories` | Create category |
| GET | `/api/public/products` | List, paginated + sorted |
| GET | `/api/public/products/keyword/{keyword}` | Search by keyword |
| GET | `/api/public/categories/{id}/products` | Filter by category |
| POST | `/api/admin/categories/{id}/product` | Add product to category |
| PUT | `/api/products/{id}/image` | Upload/replace product image |

**Cart & Addresses — requires JWT**
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/carts/products/{productId}/quantity/{qty}` | Add product to cart |
| GET | `/api/carts/users/cart` | Get logged-in user's cart |
| PUT | `/api/cart/products/{productId}/quantity/{op}` | Increase / decrease quantity |
| POST | `/api/addresses` | Add address |
| GET | `/api/users/addresses` | Get logged-in user's addresses |

**Orders — requires JWT**
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/order/users/payments/{paymentMethod}` | Place order from cart |

Full request/response schemas and the rest of the endpoints (update/delete on every module) are in Swagger UI once the app is running.

## What's Next

- React frontend — in progress
- Real payment gateway integration (currently simulated fields on the order/payment model)
- Deployment + live demo link

---
Live: *deploying soon, alongside the React frontend* · Swagger UI: `http://localhost:8080/swagger-ui/index.html`

Tanjim Hossain — CS Undergraduate · Backend Developer (Java & Spring Boot)