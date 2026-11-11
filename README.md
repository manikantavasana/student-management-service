# Student Management

A simple application to manage students, courses, and course enrollments.

## Technology

- Java 17 and Spring Boot 3.3
- Spring MVC, Spring Data JPA, and Hibernate
- Angular 22, RxJS, reactive forms, and Bootstrap 5
- H2 file database
- JUnit 5, Mockito, and MockMvc

## Features

- Create, view, update, and delete students
- Create, view, update, and delete courses
- Assign courses to a student
- Form validation and API error handling
- Confirmation before deleting a record
- Backend unit and integration tests

## Build and run the application

### Prerequisites

- JDK 17 or later

The Maven Wrapper is included, so Maven does not need to be installed separately. The build downloads a local Node.js installation and packages the Angular application inside the Spring Boot JAR.

Run the build from the project root.

macOS or Linux:

```bash
./mvnw clean package
```

Windows PowerShell or Command Prompt:

```powershell
.\mvnw.cmd clean package
```

Start the application:

```bash
java -jar backend/target/student-management-service-1.0.0-SNAPSHOT.jar
```

Open `http://localhost:8090`.

### Application structure

Spring Boot serves both the Angular application and `/api` endpoints from port `8090`. During the Maven build, Angular files are copied into the executable Spring Boot JAR.

## Database

The application uses a file-based H2 database, so no separate database installation is needed. Hibernate creates the tables when the backend starts. Existing data is retained between restarts.

The database file is created here:

```text
data/student-management-service.mv.db
```

### H2 console

Keep the backend running and open `http://localhost:8090/h2-console`.

| Field | Value |
| --- | --- |
| Driver Class | `org.h2.Driver` |
| JDBC URL | `jdbc:h2:file:./data/student-management-service` |
| User Name | `sa` |
| Password | Leave blank |

The main tables are:

| Table | Description |
| --- | --- |
| `STUDENTS` | Student details |
| `COURSES` | Course details |
| `STUDENT_COURSES` | Student and course relationship |

### Sample data

Sample data is not inserted automatically. To add it:

1. Start the backend.
2. Connect to the H2 console.
3. Open `backend/src/main/resources/db/sample-data.sql`.
4. Copy the SQL into the console and run it.

The script can be run more than once without creating duplicate records.

### Reset the database

1. Stop the backend.
2. Delete `data/student-management-service.mv.db` if the existing data is not needed.
3. Start the backend again to create an empty database.

Do not delete the database file while the backend is running.

## API endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get a student |
| POST | `/api/students` | Create a student |
| PUT | `/api/students/{id}` | Update a student |
| DELETE | `/api/students/{id}` | Delete a student |
| GET | `/api/courses` | Get all courses |
| GET | `/api/courses/{id}` | Get a course |
| POST | `/api/courses` | Create a course |
| PUT | `/api/courses/{id}` | Update a course |
| DELETE | `/api/courses/{id}` | Delete a course |

Student email and course code must be unique. A course cannot be deleted while students are enrolled in it.

## Tests

Run the tests from the project root.

macOS or Linux:

```bash
./mvnw test
```

Windows PowerShell or Command Prompt:

```powershell
.\mvnw.cmd test
```

## Project structure

```text
backend/src/main/java/com/studentmanagement
├── controller
├── domain
├── dto
├── exception
├── repository
└── service

frontend/src/app
├── core
├── courses
├── shared
└── students
```
