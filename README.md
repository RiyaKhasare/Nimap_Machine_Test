# Nimap_Machine_Test

# Spring Boot Machine Test - Category & Product Management

## Project Overview
The **Category & Product Management System** is a Spring Boot-based application designed to manage product categories and their associated products. The system provides a set of RESTful APIs that allow users to perform CRUD operations on both categories and products. The application uses Spring Data JPA for database interaction, Hibernate for ORM, and MySQL as the relational database management system.

The application supports server-side pagination for both categories and products, ensuring efficient handling of large datasets. A one-to-many relationship is implemented, where one category can have multiple products. The system also ensures that product details are enriched with category information when fetching product data.

## Prerequisites
- Java 17
- Maven
- MySQL Database

## Technology Stack
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok

## Database Configuration
1. Create a MySQL database named `machine_test`.
2. Update database credentials in `src/main/resources/application.properties`.

## Configuration Details
- **Port**: 8081 (changed from default 8080 due to port conflict)
- **Database**: MySQL
- **ORM**: Hibernate
- **Pagination**: Server-side pagination (10 items per page)

## API Endpoints

### Category Endpoints
- `GET /api/categories?page={pageNumber}` - Retrieve all categories with pagination.
- `POST /api/categories` - Create a new category.
- `GET /api/categories/{id}` - Retrieve a specific category by ID.
- `PUT /api/categories/{id}` - Update an existing category.
- `DELETE /api/categories/{id}` - Delete a category.

### Product Endpoints
- `GET /api/products?page={pageNumber}` - Retrieve all products with pagination.
- `POST /api/products?categoryId={categoryId}` - Create a new product.
- `GET /api/products/{id}` - Retrieve a specific product by ID.
- `PUT /api/products/{id}` - Update an existing product.
- `DELETE /api/products/{id}` - Delete a product.

## Relationship
- One Category can have multiple Products (One-to-Many relationship).
- Each Product belongs to a Category.

## Setup Instructions
1. Clone the repository.
2. Configure MySQL database in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/machine_test
    spring.datasource.username=root
    spring.datasource.password=mysql#
    spring.jpa.hibernate.ddl-auto=update
    server.port=8081
    ```
3. Run `mvn clean install` to build the project.
4. Start the application using `mvn spring-boot:run`.

## Postman Collection
Included in the repository for API testing.

## Notes
- Validation is implemented for entities.
- Server-side pagination is mandatory for both categories and products.
- Product details include associated category information.

## Recommended Tools
- Postman for API testing.
- MySQL Workbench for database management.

## Troubleshooting
- Ensure MySQL is running.
- Check database connection credentials in `application.properties`.
- Verify port 8081 is available (change it if necessary).



