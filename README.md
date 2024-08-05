# <h1 align="center"> Social Media API </h1>
___ 
<p align="center">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</p>


---

<p align="left">

## Overview

InstaAPI is a robust backend framework designed to serve as the foundational backbone for various social media applications. This versatile API offers comprehensive endpoints for seamless integration and manipulation, making it adaptable for a wide range of social media functionalities. Key features include post management (creating, updating, and deleting posts), comment handling (adding, editing, and removing comments on posts), and user interactions (following and unfollowing users). InstaAPI is engineered to provide a flexible and scalable solution for developers looking to build or enhance social media platforms.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java 17
- **Database:** MySQL
- **Build Tool:** Maven
- **Documentation:** SpringDoc OpenAPI (Swagger UI)

## Project Structure

The project follows a clean and organized structure:

- **Main Application Class:** This is the main entry point for the application, initializing the Spring Boot framework.
- **Entities:** The application includes the following main entities: Users, Roles, Status, Posts, Comments, and Followers. Additional entities can be added as needed.
- **Security Configuration:** This section handles the custom security filter and JWT token creation. It also includes DTOs to abstract the entity structure from API users.
- **Error Handling:** Custom error handling is implemented, along with an error service that logs common errors in a database for future troubleshooting.
- **Controller Classes:** These are the exposed endpoints that allow users to create, read, update, and delete information.
- **Service Classes:** This layer contains the business logic, ensuring separation of concerns within the application.
- **Repository Interfaces:** Utilizes Spring Data JPA to manage database interactions and queries.

  ## Data Flow

The Instagram Backend Application follows a structured data flow that encompasses user management, post creation, commenting, and liking. Here's an overview of how data flows through the application:

1. **User Registration and Authentication:**

  User Registration:
    - Input: User provides a unique username and password.
    - Process:
        - The system encrypts the password for security.
        - User credentials are stored in the database.
    - Output: User is successfully registered.

User Login:
    - Input: User provides their username and password.
    - Process:
        - The system verifies the credentials.
        - Upon successful verification, a JWT token is generated.
    - Output: User receives a JWT token.

Authenticated Requests:
    - Input: User includes the JWT token in their request headers.
    - Process:
        - The system validates the JWT token.
        - If valid, the user is authorized to perform actions.
    - Output: User can update and create posts, and comment on other users' posts.

2. **Post Creation and Retrieval:**

    - Authenticated users can create posts that include an image URL.
    - Images are eventually saved in an AWS S3 bucket for easy access and storage.
    - Posts are stored in the database.
    - Users have an endpoint to retrieve all their posts.
    - Users can see all comments associated with their posts in a one-to-many relationship.
    - Posts from other users can be seen if the user follows the requested user's posts.

3. **Commenting on Posts:**

    - Users can comment on posts, either their own or others'.
    - Comments are stored in a database and can be retrieved from the related post.
    - Comments can be deleted and modified.
    - The creation date of comments is stored, as well as the edited date if the comment is modified.

4. **Following Users and Unfollowing**

   - Users can follow and unfollow other users in the database as long as they know the other user's 
   - This relationship is stored as a joint table in the database.
   - Users can unfollow others by sending a delete request.
   - Follower count and following count can be accessed.

5. **Security:**

    - User passwords and information are stored in the database.
    - Passwords are encrypted in the database.
    - A JWT token is returned to the user upon successful authentication.
    - User data is received via DTO in the body of the request, not over the URL.

6. **RESTful API Endpoints:**

   - The application exposes RESTful API endpoints to interact with user data.
   - Each endpoint is documented and adheres to REST principles.



## RESTful API Endpoints

The application provides a wide range of RESTful API endpoints for social media functionalities:

### User Management

- **Register User:** `POST /api/auth/register`
- **Login User:** `POST /api/auth/login`
- **Get User Profile:** `GET /api/users/{Id}`
- **Delete User Account:** `DELETE /api/users/{userId}`

### Post Management

- **Create Post:** `POST /api/users/{id}/posts`
- **Get All Posts:** `GET /api/users/{id}/posts`
- **Update Post:** `PUT /api/users/posts/{postId}`
- **Delete Post:** `DELETE /api/users/posts/{postId}`

### Comment Management

- **Add Comment:** `POST /api/comments`
- **Get Comments for Post:** `GET /api/comments/{postId}`
- **Update Comment:** `PUT /api/comments/{commentId}`
- **Delete Comment:** `DELETE /api/comments/{commentId}`

### Followers Management

- **Follow User:** `POST /api/follow/send`
- **Unfollow User:** `DELETE /api/follow/unfollow`
- **Follower Count:** `GET /api/follow/count/followers`
- **Following Count:** `GET /api/follow/count/following`

The API endpoints are fully documented and support the core features of a social media platform.

## Database Design

The application employs a relational database design with tables for user profiles, posts, comments, and likes. Key attributes include:

### User Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| fname              | VARCHAR(255)    | User's first name                     |
| lname              | VARCHAR(255)    | User's last name                      |
| profile_picture    | VARCHAR(255)    | URL to the user's profile picture     |
| user_name          | VARCHAR(255)    | User's username                       |
| password           | VARCHAR(255)    | User's encrypted password             |
| id                 | INT             | Unique identifier for each user       |

### Roles_Users Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| users_id           | INT             | Identifier for the user               |
| roles_id           | BIGINT          | Identifier for the role               |

### Roles Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| role               | VARCHAR(255)    | Role assigned to the user             |
| id                 | BIGINT          | Unique identifier for each role       |

### Post Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| path               | VARCHAR(255)    | Path to the post content              |
| body               | VARCHAR(255)    | Body content of the post              |
| created_at         | DATETIME(6)     | Timestamp when the post was created   |
| title              | VARCHAR(255)    | Title of the post                     |
| user_id            | INT             | Identifier for the user who created the post |
| id                 | BIGINT          | Unique identifier for each post       |

### Comment Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| comment            | VARCHAR(255)    | The content of the comment            |
| created_on         | DATETIME(6)     | Timestamp when the comment was created|
| post_id            | BIGINT          | Identifier for the related post       |
| user_id            | INT             | Identifier for the user who made the comment |
| id                 | INT             | Unique identifier for each comment    |

### Followers Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| followed_at        | DATETIME(6)     | Timestamp when the follow action occurred |
| follower_id        | INT             | Identifier for the follower           |
| following_id       | INT             | Identifier for the user being followed|
| id                 | INT             | Unique identifier for each follow relationship |

### Error_Log Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| details            | VARCHAR(255)    | Details of the error                  |
| message            | VARCHAR(255)    | Error message                         |
| time_stamp         | DATETIME(6)     | Timestamp of the error occurrence     |
| http_method        | VARCHAR(255)    | HTTP method that caused the error     |
| id                 | BIGINT          | Unique identifier for each error log  |

### Status Table

| Column Name        | Data Type       | Description                           |
| ------------------ | --------------- | ------------------------------------- |
| path               | VARCHAR(255)    | Path to the status content            |
| status_id          | INT             | Identifier for the status             |
| time_stamp         | DATETIME(6)     | Timestamp when the status was created |
| user_id            | INT             | Identifier for the user who created the status |
| id                 | INT             | Unique identifier for each status     |



## Database Details

The Instagram Backend Application utilizes a MySQL database to persist user data, posts, comments, Status, and other relevant information. Here are the key details about the database:

- **Database Engine:** MySQL
- **Database Schema:** InstaAPI

### Database Configuration

The database connection properties are specified in the `application.properties` file, including the database URL, username, and password. Here is an example configuration for MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/InstaAPI
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Make sure to replace `your_username` and `your_password` with your actual MySQL credentials.

The database schema (`InstaAPI`) is automatically created based on the entity mappings defined in the application. Hibernate, coupled with Spring Data JPA, handles the database schema generation and management.

## Project Summary

InstaAPI is a skeleton API designed for social media applications, featuring built-in security and ready for deployment. Simply add your custom business logic and entities according to your specific needs. The API offers comprehensive endpoints and is highly modular, with a microservice-like structure that simplifies debugging and problem identification. Its decoupled nature allows for the addition of new features without interfering with the main structure. The API also supports versioning, making it adaptable for future enhancements. This is version 1 (V1), with plans to release a more complete version in the future.

### Key Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven

### Key Features

- User registration and login
- User profile management
- Post creation, retrieval, and modification
- Commenting on posts
- Robust security with Spring Security

<!-- Acknowledgments -->
## Acknowledgments

I would like to express my gratitude to the Spring Boot team for building such an easy-to-use and modular framework that is industry-leading. Additionally, I extend my thanks to Professor Ranga Karanam from in28Minutes Official on Udemy for all the comprehensive knowledge and best practices shared.

<!-- Contact -->
## Contact

For questions or feedback, please contact morabmb27@gmail.com or at my linkedin https://www.linkedin.com/in/brianmora-softwareengineer/.
