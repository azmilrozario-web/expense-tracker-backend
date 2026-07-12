# Expense Tracker Backend

Spring Boot REST API backend for the Expense Tracker application.

## Frontend Repository

The frontend for this project is available here:

https://github.com/azmilrozario-web/expense-tracker

---

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST API

---

## Features

- Expense CRUD
- Category CRUD
- Calculate total expenses
- Calculate total expenses by category
- Filter expenses by category
- Filter expenses by date
- Filter expenses by date range

---

## Architecture

```text
Controller
      ↓
Service Interface
      ↓
Service Implementation
      ↓
Repository
      ↓
MySQL Database
```

---

## API Endpoints

### Expenses

- GET `/expenses`
- GET `/expenses/{id}`
- POST `/expenses`
- PUT `/expenses/{id}`
- DELETE `/expenses/{id}`

### Categories

- GET `/categories`
- GET `/categories/{id}`
- POST `/categories`
- PUT `/categories/{id}`
- DELETE `/categories/{id}`

---

## Running the Project

1. Clone the repository.
2. Configure your MySQL database.
3. Update `application.properties`.
4. Run the application using Maven or your IDE.

---

Developed as the backend component of the Expense Tracker full-stack application.