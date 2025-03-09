# JDBC CRUD Operations using Try-With-Resources

## Overview
This repository demonstrates **CRUD (Create, Read, Update, Delete) operations** in Java using **JDBC (Java Database Connectivity)**. The code follows best practices by utilizing **Try-With-Resources** for efficient resource management.

## Features
- **Insert Data** into a MySQL database.
- **Retrieve Data** from the database and display it.
- **Update Data** for an existing record.
- **Delete Data** from the database.
- Uses **Try-With-Resources** to handle connections safely.

## Technologies Used
- **Java** (JDK 8+)
- **JDBC**
- **MySQL**

## Database Setup
1. Install MySQL and create a database named `jdbcdemo`.
2. Create a table named `employees3` using the following SQL query:

```sql
CREATE TABLE employees3 (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    designation VARCHAR(50),
    salary DOUBLE
);
```

## How to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/Pradeepkamma/JDBC_CrudOperations_TryWithResources.git
   ```
2. Open the project in your favorite IDE (Eclipse, IntelliJ, VS Code).
3. Make sure you have the MySQL JDBC driver (`mysql-connector-java`) added to your project.
4. Update database credentials in `CurdOperationsTryWithResources.java`:
   ```java
   private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbcdemo";
   private static final String USER = "root";
   private static final String PASSWORD = "admin";
   ```
5. Run `CurdOperationsTryWithResources.java` to perform CRUD operations.

## Contributions
Feel free to fork this repository, create a branch, make improvements, and submit a pull request!

## License
This project is licensed under the **MIT License**.

Happy Coding! 🚀

