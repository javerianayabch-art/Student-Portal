# Student Portal – Java Console Application

A Java console-based application that simulates a simple academic portal with role-based access for teachers and students.  
The project is designed to practice core Java concepts and Object-Oriented Programming principles.

## Login System
The application starts with a login screen where users must enter a valid username and password.  
If incorrect credentials are entered, the user is prompted to try again.

## User Roles & Features
### Teacher
- Login using username and password
- Update student marks
- Upload learning resources
- Change own username and password
- View teacher-specific dashboard

### Student
- Login using username and password
- View marks, percentage, grade, and CGPA
- Access uploaded learning resources
- Change own username and password
- View student-specific dashboard

## Object-Oriented Programming Concepts Used

This project demonstrates all four pillars of Object-Oriented Programming:

- **Abstraction**  
  Implemented using an abstract class (`UserLogin`) that defines common behavior for all users.

- **Encapsulation**  
  Sensitive data such as username and password are kept private and modified through controlled setter methods.

- **Inheritance**  
  `Student` and `Teacher` classes inherit common functionality from the `UserLogin` class.

- **Polymorphism**  
  The `dashboard()` method is overridden in both `Student` and `Teacher` classes to provide role-specific behavior.

## How to Run the Project
1. Clone the repository
2. Open the project in any Java-supported IDE (VS Code / IntelliJ / Eclipse)
3. Compile and run the `StudentPortal.java` file
4. Follow the on-screen instructions in the console to log in as a teacher or student

## Technologies Used
- Java
- VS Code
- Command Line Interface (CLI)
