# Bank Application

A simple bank application developed using Spring Boot. This project showcases basic banking operations such as account management, 
transactions, and fund transfers. The application uses REST APIs to interact with clients and demonstrates the use of various Spring Boot features.

## Features

- **Create Account**: Allows users to create a new bank account.
- **Get Account Details**: Fetches details of a specific account by its ID.
- **Deposit Funds**: Deposits a specified amount into an account.
- **Withdraw Funds**: Withdraws a specified amount from an account.
- **Transfer Funds**: Transfers funds between two accounts.
- **Get All Accounts**: Retrieves a list of all accounts.
- **Delete Account**: Deletes an account by its ID.
- **Get Account Transactions**: Fetches a list of transactions associated with an account.

## Technologies Used

- **Java**: The primary programming language.
- **Spring Boot**: Framework for building the REST API and managing dependencies.
- **JPA/Hibernate**: For database interactions and ORM.
- **MySQL Database**: Database for development and testing.
- **Maven**: Build and dependency management tool.

## Project Structure

- **Controller**: Contains REST controllers to handle HTTP requests and responses.
- **DTO**: Data Transfer Objects used to transfer data between layers.
- **Entity**: JPA entities representing the database tables.
- **Exception**: Custom exception classes for error handling.
- **Mapper**: Utility classes for mapping between entities and DTOs.
- **Repository**: Interfaces for CRUD operations on entities.
- **Service**: Business logic and service layer.

## Getting Started

### Prerequisites

- JDK 11 or later
- Maven
 
## API Endpoints

The application will start on `http://localhost:8080`.

- **Create Account**: `POST /api/accounts`
- **Get Account by ID**: `GET /api/accounts/{id}`
- **Deposit Funds**: `PUT /api/accounts/{id}/deposit`
- **Withdraw Funds**: `PUT /api/accounts/{id}/withdraw`
- **Transfer Funds**: `POST /api/accounts/transfer`
- **Get All Accounts**: `GET /api/accounts`
- **Delete Account**: `DELETE /api/accounts/{id}`
- **Get Account Transactions**: `GET /api/accounts/{id}/transactions`

## Example Requests

**Create Account**:
```http
POST /api/accounts
Content-Type: application/json

{
  "accountHolderName": "John Doe",
  "balance": 1000.00
}
```

**Deposit Funds**:
```http
PUT /api/accounts/1/deposit
Content-Type: application/json

{
  "amount": 500.00
}
```

**Transfer Funds**:
```http
POST /api/accounts/transfer
Content-Type: application/json

{
  "fromAccountId": 1,
  "toAccountId": 2,
  "amount": 200.00
}
```


## Acknowledgments

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [JPA/Hibernate Documentation](https://hibernate.org/)
