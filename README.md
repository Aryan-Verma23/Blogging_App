# Blog Application

## Overview
The Blog Application is a RESTful API built with Spring Boot. It provides functionality for managing users and their related data. This application is designed to demonstrate core concepts of Spring Boot, Hibernate, and JPA while providing a foundation for more complex blog management systems.

## Features
- User Management:
  - Create a new user
  - Update user details
  - Retrieve user details by ID
  - Retrieve all users
  - Delete a user
- Exception handling with custom exceptions
- DTOs for data transfer between layers

## Technologies Used
- **Java**: Core language for development
- **Spring Boot**: Framework for building the application
- **Hibernate**: ORM tool for database operations
- **MySQL**: Database for data persistence
- **Lombok**: Simplifies boilerplate code for models
- **POSTMAN**: A Comprehensive set of API tools 

## Project Structure
```
blog_app
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.aryan.blog
│   │   │   │   ├── BlogAppApplication.java
│   │   │   │   ├── entities
│   │   │   │   │   └── User.java
│   │   │   │   ├── exceptions
│   │   │   │   │   └── ResourceNotFoundException.java
│   │   │   │   ├── payloads
│   │   │   │   │   └── UserDto.java
│   │   │   │   ├── repositories
│   │   │   │   │   └── UserRepo.java
│   │   │   │   ├── services
│   │   │   │   │   ├── UserService.java
│   │   │   │   │   └── impl
│   │   │   │   │       └── UserServiceImpl.java
│   │   ├── resources
│   │   │   └── application.properties
├── README.md
```

## Getting Started

### Prerequisites
- Java 17 or higher
- MySQL database
- Maven

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd blog_app
   ```

2. Configure the database:
   - Update the `application.properties` file with your MySQL credentials:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
     spring.datasource.username=<your-username>
     spring.datasource.password=<your-password>
     ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### API Endpoints
| HTTP Method | Endpoint              | Description            |
|-------------|-----------------------|------------------------|
| POST        | `/users`              | Create a new user      |
| PUT         | `/users/{userId}`     | Update user details    |
| GET         | `/users/{userId}`     | Get user by ID         |
| GET         | `/users`              | Get all users          |
| DELETE      | `/users/{userId}`     | Delete a user          |

### Error Handling
- The application uses `ResourceNotFoundException` to handle cases where a requested resource is not found.
- Example error response:
  ```json
  {
    "message": "User not found with Id : 1",
    "resourceName": "User",
    "fieldName": "Id",
    "fieldValue": 1
  }
  ```

## Contributing
Contributions are welcome! Feel free to fork the repository and submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Author
- Aryan

---
Feel free to reach out with any questions or suggestions!

