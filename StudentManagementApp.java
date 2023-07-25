import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class representing an individual student
class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;
    // Add other relevant details as needed

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    // Add setter methods if required
}

// Class representing the Student Management System
class StudentManagementSystem {
    private List<Student> students;
    private String dataFile;

    public StudentManagementSystem(String dataFile) {
        this.dataFile = dataFile;
        this.students = new ArrayList<>();
        loadStudentsFromFile();
    }

    // Add a new student to the list
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Remove a student from the list based on roll number
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully.");
    }

    // Search for a student based on roll number and return the student object
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    // Display details of all students in the list
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() +
                    ", Roll Number: " + student.getRollNumber() +
                    ", Grade: " + student.getGrade());
        }
    }

    // Load student data from the file (if available)
    private void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // In case of error or first run, ignore and use the empty list of students
        }
    }

    // Save student data to the file
    public void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving student data to file: " + e.getMessage());
        }
    }
}

// Main class for the Student Management Application
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem("student_data.txt");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for a Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Student Data to File");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    sms.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    sms.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student searchedStudent = sms.searchStudent(rollToSearch);
                    if (searchedStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("Name: " + searchedStudent.getName() +
                                ", Roll Number: " + searchedStudent.getRollNumber() +
                                ", Grade: " + searchedStudent.getGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    sms.saveStudentsToFile();
                    System.out.println("Student data saved to file.");
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
