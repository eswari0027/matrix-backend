
Matrix Fullstack (HTML frontend + Spring Boot backend + MS SQL Server)

Quick start:
1. Ensure Java 17 and Maven are installed.
2. Ensure SQL Server is running and accessible at localhost:1433 (or change application.properties).
3. Create database 'matrixdb' or allow Hibernate to create tables (ddl-auto=update).
4. Edit backend/src/main/resources/application.properties and set your SQL Server username/password.
5. Start backend:
   cd backend
   mvn clean install
   mvn spring-boot:run
6. Open frontend/index.html in your browser (or serve it from any static server).
