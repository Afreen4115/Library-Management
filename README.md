# 📚 Library Management System

A comprehensive command-line Library Management System built with Java and MySQL. This system provides efficient book cataloging, rental tracking, and search capabilities for managing library operations.

## ✨ Features

### Book Management
- **Create Books**: Bulk import books from CSV files
- **Read All Books**: Display complete book catalog
- **Update Books**: Modify book information via CSV files
- **Delete Books**: Remove books by Book ID
- **Search Functionality**:
  - Search by Book ID (supports multiple IDs)
  - Search by Genre
  - Search by Title
  - Search by Author

### Rental Management
- **Create Rental Records**: Bulk import rented books from CSV files
- **View All Rentals**: Display all rented books with rental details
- **Delete Rental Records**: Remove rental entries by Book ID
- **Search Rentals**:
  - Search by Book ID
  - Search by Title

### Additional Features
- **CSV File Processing**: Bulk operations using CSV files
- **Database Integration**: MySQL database for persistent storage
- **Command-Line Interface**: Easy-to-use CLI with command flags
- **DAO Pattern**: Clean separation of data access logic
- **Error Handling**: Comprehensive exception handling

## 🛠️ Technologies Used

- **Java**: Core programming language (JDK 8+)
- **MySQL**: Relational database management system
- **JDBC**: Java Database Connectivity API
- **MySQL Connector/J**: MySQL JDBC driver (v8.0.27)

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

1. **Java Development Kit (JDK)**
   - Version 8 or higher
   - Verify installation: `java -version`

2. **MySQL Server**
   - Version 5.7 or higher (or MySQL 8.0+)
   - Verify installation: `mysql --version`

3. **MySQL Connector/J**
   - Included in the `lib/` directory (v8.0.27)
   - Or download from [MySQL Official Site](https://dev.mysql.com/downloads/connector/j/)

4. **IDE or Text Editor**
   - VS Code, IntelliJ IDEA, Eclipse, or any Java-compatible IDE

## 🗄️ Database Setup

### Step 1: Create Database

```sql
CREATE DATABASE library;
USE library;
```

### Step 2: Create Books Table

```sql
CREATE TABLE books (
    BookId INT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    Genre VARCHAR(100) NOT NULL
);
```

### Step 3: Create RentedBooks Table

```sql
CREATE TABLE rentedbooks (
    BookId INT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    Genre VARCHAR(100) NOT NULL,
    DateOfReturn VARCHAR(50) NOT NULL,
    Rent INT NOT NULL
);
```

## ⚙️ Configuration

### Database Connection Setup

**⚠️ IMPORTANT**: Update database credentials in `src/ConnectionJDBC.java`:

```java
final static String url = "jdbc:mysql://localhost:3306/library";
final static String uname = "your_username";      // Change this
final static String password = "your_password";  // Change this
```

**Security Note**: For production use, consider:
- Using environment variables for credentials
- Implementing a configuration file (not tracked in git)
- Using connection pooling for better performance

## 🚀 Installation

### Step 1: Clone the Repository

```bash
git clone https://github.com/yourusername/Library-Management.git
cd Library-Management
```

### Step 2: Compile the Project

```bash
# Navigate to src directory
cd src

# Compile all Java files
javac -cp "../lib/mysql-connector-java-8.0.27.jar" *.java

# Or compile from project root
javac -cp "lib/mysql-connector-java-8.0.27.jar" src/*.java -d bin
```

### Step 3: Run the Application

```bash
# From src directory
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -h

# Or from project root
java -cp "bin:lib/mysql-connector-java-8.0.27.jar" App -h
```

## 📖 Usage Guide

### Command Reference

#### Book Management Commands

| Flag | Command | Description | Example |
|------|---------|-------------|---------|
| `-a` | Create Books | Import books from CSV file | `java App -a books.csv` |
| `-b` | Read All Books | Display all books in catalog | `java App -b` |
| `-c` | Update Books | Update books from CSV file | `java App -c update.csv` |
| `-d` | Delete Book | Delete book by Book ID | `java App -d 101` |
| `-e` | Search by Book ID | Search one or more books by ID | `java App -e 101 102 103` |
| `-f` | Search by Genre | Search books by genre | `java App -f Fantasy` |
| `-g` | Search by Title | Search books by title | `java App -g "Harry Potter"` |
| `-au` | Search by Author | Search books by author | `java App -au "J.K.Rowling"` |

#### Rental Management Commands

| Flag | Command | Description | Example |
|------|---------|-------------|---------|
| `-i` | Create Rentals | Import rented books from CSV | `java App -i rentals.csv` |
| `-j` | Read All Rentals | Display all rented books | `java App -j` |
| `-k` | Delete Rental | Delete rental by Book ID | `java App -k 534` |
| `-l` | Search Rental by ID | Search rental by Book ID | `java App -l 534` |
| `-m` | Search Rental by Title | Search rental by title | `java App -m "RomeoAndJuliet"` |

#### Help Command

| Flag | Command | Description |
|------|---------|-------------|
| `-h` | Help | Display help menu with all commands |

### CSV File Format

#### Books CSV Format (`test.CSV`)

```csv
BookId,Title,Author,Genre
102,'CrimeAndPunishment','Fyodordostoyevsky','Crime'
105,'LifeOfpi','Yan martel','Adventure'
103,'Harry Potter and the Philosopher Stone','J.K Rowling','Fantasy'
```

**Format**: `BookId,Title,Author,Genre`
- BookId: Integer (unique identifier)
- Title: String (book title)
- Author: String (author name)
- Genre: String (book genre/category)

#### Rented Books CSV Format (`testR.CSV`)

```csv
BookId,Title,Author,Genre,DateOfReturn,Rent
534,'RomeoAndJuliet','WilliamShakespeare','Classic','05/12/21',50
285,'Mahabharat','Vyasa','Devotional','23/02/21',100
```

**Format**: `BookId,Title,Author,Genre,DateOfReturn,Rent`
- BookId: Integer (unique identifier)
- Title: String (book title)
- Author: String (author name)
- Genre: String (book genre)
- DateOfReturn: String (return date in DD/MM/YY format)
- Rent: Integer (rental fee)

### Usage Examples

#### Example 1: Import Books from CSV

```bash
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -a test.CSV
```

**Output**:
```
1 Books rows created.
1 Books rows created.
...
```

#### Example 2: Display All Books

```bash
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -b
```

**Output**:
```
[BookId:102 Title:CrimeAndPunishment Author:Fyodordostoyevsky Genre:Crime]
[BookId:105 Title:LifeOfpi Author:Yan martel Genre:Adventure]
...
```

#### Example 3: Search Books by Genre

```bash
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -f Fantasy
```

**Output**:
```
[BookId:103 Title:Harry Potter and the Philosopher Stone Author:J.K Rowling Genre:Fantasy]
[BookId:684 Title:Harry Potter-3 Author:J.K.Rowling Genre:Fantasy]
...
```

#### Example 4: Search Multiple Books by ID

```bash
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -e 101 102 103
```

**Output**:
```
[BookId:101 Title:The Eagle Has Landed Author:Jack Higgins Genre:Thriller]
[BookId:102 Title:CrimeAndPunishment Author:Fyodordostoyevsky Genre:Crime]
[BookId:103 Title:Harry Potter and the Philosopher Stone Author:J.K Rowling Genre:Fantasy]
```

#### Example 5: Create Rental Records

```bash
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -i testR.CSV
```

**Output**:
```
1 RentedBooks rows created.
1 RentedBooks rows created.
...
```

#### Example 6: View All Rentals

```bash
java -cp ".:../lib/mysql-connector-java-8.0.27.jar" App -j
```

**Output**:
```
[BookId:534 Title:RomeoAndJuliet Author:WilliamShakespeare Genre:Classic DateOfReturn:05/12/21 Rent:50]
[BookId:285 Title:Mahabharat Author:Vyasa Genre:Devotional DateOfReturn:23/02/21 Rent:100]
...
```

## 📁 Project Structure

```
Library-Management/
├── src/                          # Source code directory
│   ├── App.java                  # Main application entry point
│   ├── Book.java                 # Book entity class
│   ├── Reader.java               # CSV file reader utility
│   ├── RentedBook.java           # RentedBook entity (extends Book)
│   ├── BookDAO.java              # Data Access Object for Books
│   ├── RentedBookDAO.java        # Data Access Object for RentedBooks
│   ├── ConnectionJDBC.java       # Database connection manager
│   ├── test.CSV                  # Sample books CSV file
│   ├── testR.CSV                 # Sample rented books CSV file
│   └── testUpdate.CSV            # Sample update CSV file
├── lib/                          # External libraries
│   └── mysql-connector-java-8.0.27.jar
├── bin/                          # Compiled class files
└── README.md                     # This file
```

## 🏗️ Architecture

### Class Diagram Overview

```
App (Main)
├── Book (Entity)
│   └── RentedBook (extends Book)
├── BookDAO (Data Access)
├── RentedBookDAO (Data Access)
├── Reader (File I/O)
└── ConnectionJDBC (Database Connection)
```

### Design Patterns

1. **DAO Pattern**: Separates data access logic from business logic
   - `BookDAO`: Handles all database operations for books
   - `RentedBookDAO`: Handles all database operations for rented books

2. **Inheritance**: `RentedBook` extends `Book` to reuse common properties

3. **Singleton-like Pattern**: `ConnectionJDBC` provides centralized database connection

## 🔍 Database Schema

### Books Table

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| BookId | INT | PRIMARY KEY | Unique book identifier |
| Title | VARCHAR(255) | NOT NULL | Book title |
| Author | VARCHAR(255) | NOT NULL | Author name |
| Genre | VARCHAR(100) | NOT NULL | Book genre/category |

### RentedBooks Table

| Column | Type | Constraints | Description |
|--------|------|-------------|-------------|
| BookId | INT | PRIMARY KEY | Unique book identifier |
| Title | VARCHAR(255) | NOT NULL | Book title |
| Author | VARCHAR(255) | NOT NULL | Author name |
| Genre | VARCHAR(100) | NOT NULL | Book genre |
| DateOfReturn | VARCHAR(50) | NOT NULL | Return date |
| Rent | INT | NOT NULL | Rental fee |

## 🧪 Testing

### Sample Test Data

The project includes sample CSV files for testing:

1. **test.CSV**: Contains 25 sample books
2. **testR.CSV**: Contains 6 sample rental records
3. **testUpdate.CSV**: Sample data for update operations

### Testing Workflow

1. **Setup Database**: Create tables as described in Database Setup
2. **Import Books**: `java App -a test.CSV`
3. **View Books**: `java App -b`
4. **Search Books**: Test various search commands
5. **Import Rentals**: `java App -i testR.CSV`
6. **View Rentals**: `java App -j`
7. **Test Updates**: `java App -c testUpdate.CSV`
8. **Test Deletions**: `java App -d <BookId>`

## 🐛 Troubleshooting

### Common Issues

#### 1. Connection Error
```
java.sql.SQLException: Access denied for user 'root'@'localhost'
```
**Solution**: 
- Verify MySQL credentials in `ConnectionJDBC.java`
- Ensure MySQL server is running: `sudo systemctl start mysql`
- Check user permissions in MySQL

#### 2. ClassNotFoundException
```
java.lang.ClassNotFoundException: com.mysql.cj.jdbc.Driver
```
**Solution**: 
- Ensure MySQL Connector JAR is in classpath
- Check JAR file path in compilation command

#### 3. Table Not Found
```
java.sql.SQLException: Table 'library.books' doesn't exist
```
**Solution**: 
- Create database and tables as per Database Setup section
- Verify database name matches connection URL

#### 4. File Not Found
```
java.io.FileNotFoundException: test.CSV
```
**Solution**: 
- Ensure CSV file exists in the correct directory
- Use absolute path or relative path from execution directory
- Check file permissions

## 🔒 Security Considerations

1. **Database Credentials**: 
   - ⚠️ Never commit database passwords to version control
   - Use environment variables or configuration files (excluded from git)
   - Consider using `.env` files or Java properties files

2. **SQL Injection Prevention**: 
   - ✅ Project uses PreparedStatements (already implemented)
   - ✅ Parameterized queries prevent SQL injection

3. **Connection Management**: 
   - Consider implementing connection pooling for production
   - Ensure proper connection closing (currently implemented)

## 🚧 Future Enhancements

Potential improvements for the project:

- [ ] GUI implementation (Swing/JavaFX)
- [ ] User authentication and authorization
- [ ] Due date tracking and overdue notifications
- [ ] Fine calculation system
- [ ] Member/Reader management
- [ ] Book availability status
- [ ] Advanced search with filters
- [ ] Export functionality (PDF/Excel reports)
- [ ] Logging system
- [ ] Unit tests (JUnit)
- [ ] Configuration file support
- [ ] REST API implementation

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Coding Standards

- Follow Java naming conventions
- Add comments for complex logic
- Maintain consistent code formatting
- Write meaningful commit messages


## 🙏 Acknowledgments

- MySQL Community for excellent database support
- Java community for robust libraries and tools
- Contributors and testers of this project

## 📞 Support



**Happy Coding! 📚✨**
