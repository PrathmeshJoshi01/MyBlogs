
# MyBlogs - React & Spring Boot Project

Welcome to the **MyBlogs** project, a blog listing page where users can view all available blogs. This project uses **React** for the frontend and **Spring Boot** for the backend. It fetches blog data from the Spring Boot backend service and displays it in a beautiful, responsive UI. The page includes a motivational image and a background image to enhance the user experience.

## Features

- View a list of blogs with details such as title, author, and creation date.
- Responsive design with a clean, modern UI built with **React** and **Bootstrap**.
- Loading state with a spinner while fetching data.
- Background image to create an aesthetically pleasing environment for the user.
- Motivational image to add a touch of inspiration to the page.
- Conditional rendering to handle loading states and empty data scenarios.
- Spring Boot backend that serves blog data to the frontend.

## Tech Stack

### Frontend:
- **React**: JavaScript library for building user interfaces.
- **React Bootstrap**: UI components based on Bootstrap for faster development.
- **Axios**: Promise-based HTTP client for fetching blog data from the backend.
- **Bootstrap**: A popular front-end framework for building responsive websites.
- **JavaScript (ES6+)**: JavaScript language features such as hooks (`useState`, `useEffect`).

### Backend:
- **Spring Boot**: Java framework for building RESTful APIs.
- **Spring Data JPA**: For database access and object-relational mapping (ORM).
- **H2 Database** (or any other database): For storing blog data (can be configured in `application.properties`).
- **Spring Web**: For building web-based applications, handling HTTP requests.

## Project Setup

Follow these steps to get the project up and running on your local machine:

### Prerequisites

- **Node.js** (v12.0 or higher) for frontend
- **npm** (v6.0 or higher) for frontend
- **Java** (v8 or higher) for backend
- **Maven** or **Gradle** (depending on the build tool used)
- **Spring Boot** (v2.x or higher)

### Frontend Setup

1. Clone the frontend repository:

   ```bash
   git clone https://github.com/your-username/all-blogs-react.git
   ```

2. Navigate to the project directory:

   ```bash
   cd all-blogs-react
   ```

3. Install the dependencies:

   ```bash
   npm install
   ```

4. Start the development server:

   ```bash
   npm start
   ```

The React app will run on `http://localhost:3000`.

### Backend Setup (Spring Boot)

1. Clone the backend repository (assuming you have a separate backend repo):

   ```bash
   git clone https://github.com/your-username/all-blogs-springboot.git
   ```

2. Navigate to the backend project directory:

   ```bash
   cd all-blogs-springboot
   ```

3. If you are using Maven, run the following command to start the Spring Boot application:

   ```bash
   ./mvnw spring-boot:run
   ```

   If you are using Gradle, run the following command:

   ```bash
   ./gradlew bootRun
   ```

The Spring Boot backend will run on `http://localhost:8080`.

### API Integration

This project fetches the blog data from the Spring Boot backend. The `blogService.js` file in the frontend contains the API call logic.

The backend exposes the following endpoint for fetching all blogs:

```http
GET http://localhost:8080/api/blogs
```

Ensure that the backend is running before starting the frontend.

### Database Configuration

The backend is set up to use **H2 Database** by default. If you'd like to use another database, update the `application.properties` file in the backend with your database connection details. Here is the default configuration for H2:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

### Folder Structure

The folder structure is organized as follows:

#### Frontend:
```
/src
  /assets                # Static images such as motivational image
  /components            # React components like AllBlogs
  /services              # Contains API services (blogService.js)
  App.js                 # Main component that renders the AllBlogs component
  index.js               # Entry point for the React application
  App.css                # Styles for the app
```

#### Backend (Spring Boot):
```
/src
  /main
    /java
      /com
        /yourdomain
          /blog
            /controller     # Contains controllers for handling HTTP requests
            /model          # Contains blog entity classes (Blog.java)
            /repository     # Repository interfaces for accessing the database
            /service        # Business logic for managing blogs
    /resources
      application.properties  # Configuration file for Spring Boot
```

### Key Components

1. **Frontend:**
   - **AllBlogs.js**: The main component that displays the list of blogs.
   - **blogService.js**: Contains the logic for making API calls to fetch the blog data.
   - **App.css**: Styles for the application, including custom styles for background and motivational images.

2. **Backend (Spring Boot):**
   - **BlogController.java**: Handles API requests related to blogs.
   - **BlogService.java**: Contains the business logic for managing blogs.
   - **BlogRepository.java**: A JPA repository interface for querying blogs from the database.
   - **Blog.java**: The entity class representing the blog structure in the database.

## How to Contribute

1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes and test them.
4. Submit a pull request with a detailed explanation of your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
