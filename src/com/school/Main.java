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

        // Create lists for AttendanceService
        ArrayList<Student> allStudents = new ArrayList<>();
        allStudents.add(alice);
        allStudents.add(bob);
        allStudents.add(charlie);
        allStudents.add(dora);
        
        ArrayList<Course> allCourses = new ArrayList<>();
        allCourses.add(math);
        allCourses.add(science);

        // Create AttendanceService
        FileStorageService storageService = new FileStorageService();
        AttendanceService attendanceService = new AttendanceService(storageService);

        // Demonstrate overloaded markAttendance methods
        System.out.println("\n--- Marking Attendance (Method 1: Using Objects) ---");
        attendanceService.markAttendance(alice, math, "Present");
        attendanceService.markAttendance(bob, science, "Absent");
        
        System.out.println("\n--- Marking Attendance (Method 2: Using IDs) ---");
        attendanceService.markAttendance(3, 101, "Present", allStudents, allCourses);
        attendanceService.markAttendance(4, 102, "Present", allStudents, allCourses);

        // Demonstrate overloaded displayAttendanceLog methods
        attendanceService.displayAttendanceLog();
        attendanceService.displayAttendanceLog(alice);
        attendanceService.displayAttendanceLog(math);

        // Save attendance data
        attendanceService.saveAttendanceData();
        
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

        // Save other data to files
        storageService.saveData(allStudents, "students.txt");
        storageService.saveData(allCourses, "courses.txt");
        
        System.out.println("\nAll data saved to files successfully!");
    }
}