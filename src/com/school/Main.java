// package com.school;

// public class Main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the School Attendance System Project!");
//         System.out.println("Session 1: Project Setup and Orientation Complete.");
// }


package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        System.out.println("\n--- School Directory ---");
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create students, teachers, and staff
        Student alice = new Student("Alice", "10th Grade");
        Student bob = new Student("Bob", "9th Grade");
        Student charlie = new Student("Charlie", "11th Grade");
        Student dora = new Student("Dora", "12th Grade");
        
        Teacher mathTeacher = new Teacher("Mr. Smith", "Mathematics");
        Teacher scienceTeacher = new Teacher("Ms. Johnson", "Science");
        
        Staff janitor = new Staff("John Doe", "Janitor");
        Staff librarian = new Staff("Jane Wilson", "Librarian");

        // Create courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Demonstrate polymorphism with school directory
        ArrayList<Person> schoolPeople = new ArrayList<>();
        schoolPeople.add(alice);
        schoolPeople.add(bob);
        schoolPeople.add(charlie);
        schoolPeople.add(dora);
        schoolPeople.add(mathTeacher);
        schoolPeople.add(scienceTeacher);
        schoolPeople.add(janitor);
        schoolPeople.add(librarian);
        
        displaySchoolDirectory(schoolPeople);

        // Create attendance records with Student and Course objects
        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(alice, math, "Present"));
        records.add(new AttendanceRecord(bob, science, "Absent"));
        records.add(new AttendanceRecord(charlie, math, "Present"));
        
        System.out.println("\n--- Attendance Log ---");
        for (AttendanceRecord record : records) {
            record.displayRecord();
        }

        // Filter students for saving
        ArrayList<Student> students = new ArrayList<>();
        for (Person person : schoolPeople) {
            if (person instanceof Student) {
                students.add((Student) person);
            }
        }
        
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(math);
        courses.add(science);

        // Save data to files
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");
        
        System.out.println("\nData saved to files successfully!");
    }
}