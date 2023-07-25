# Student Management System

The **Student Management System** is a Java console application that allows users to manage student records. It provides functionalities to add students, remove students, search for students by roll number, display all students' details, and save student data to a file.

## How to Use

1. **Compile the Code**: Compile the `StudentManagementApp.java` file using the Java compiler.

   ```bash
   javac StudentManagementApp.java
   ```

2. **Run the Application**: Execute the compiled Java class.

   ```bash
   java StudentManagementApp
   ```

3. **Main Menu**: The application will present a menu with the following options:

   - **Add Student**: Allows you to add a new student to the system. You need to enter the student's name, roll number, and grade.

   - **Remove Student**: Removes a student from the system based on their roll number.

   - **Search for a Student**: Searches for a student by their roll number and displays their details if found.

   - **Display All Students**: Shows the details of all the students currently in the system.

   - **Save Student Data to File**: Saves the current student data to a file named `student_data.txt`.

   - **Exit**: Terminates the application.

## File Handling

The application uses file handling to load and save student data to a file (`student_data.txt`). When you add or remove students or exit the application, the data is saved to the file. On subsequent runs of the application, it loads any existing student data from the file.

## Student Class

The `Student` class is a simple Java class representing an individual student. It contains attributes like name, roll number, and grade. Additional details can be added as needed by modifying the class.

## Student Management System Class

The `StudentManagementSystem` class manages the student records and provides methods to perform various operations like adding, removing, searching, and displaying student details. It utilizes the `Student` class to create and manage student objects.

## Note

- This application is intended for demonstration purposes and might require additional error handling and input validation for production use.

- The application uses a simple serialization approach to save and load student data. In real-world scenarios, more robust data storage mechanisms like databases should be considered for scalability and reliability.

- Feel free to explore, modify, and enhance the code to suit your specific requirements.

- Happy coding! 🚀
- 
