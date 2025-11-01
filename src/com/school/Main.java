// package com.school;

// public class Main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the School Attendance System Project!");
//         System.out.println("Session 1: Project Setup and Orientation Complete.");
// }


package com.school;

import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        System.out.println("\n--- School Directory ---");
        List<Person> people = regService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create services
        FileStorageService storageService = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storageService);
        AttendanceService attendanceService = new AttendanceService(storageService, registrationService);

        // Register students, teachers, and staff
        registrationService.registerStudent("Alice", "10th Grade");
        registrationService.registerStudent("Bob", "9th Grade");
        registrationService.registerStudent("Charlie", "11th Grade");
        registrationService.registerStudent("Dora", "12th Grade");
        
        registrationService.registerTeacher("Mr. Smith", "Mathematics");
        registrationService.registerTeacher("Ms. Johnson", "Science");
        
        registrationService.registerStaff("John Doe", "Janitor");
        registrationService.registerStaff("Jane Wilson", "Librarian");

        // Create courses
        registrationService.createCourse("Mathematics");
        registrationService.createCourse("Science");

        // Demonstrate overloaded markAttendance methods
        System.out.println("\n--- Marking Attendance (Using IDs) ---");
        attendanceService.markAttendance(1, 101, "Present");
        attendanceService.markAttendance(2, 102, "Absent");
        attendanceService.markAttendance(3, 101, "Present");
        attendanceService.markAttendance(4, 102, "Present");

        // Demonstrate overloaded displayAttendanceLog methods
        attendanceService.displayAttendanceLog();
        
        Student alice = registrationService.findStudentById(1);
        if (alice != null) {
            attendanceService.displayAttendanceLog(alice);
        }
        
        Course math = registrationService.findCourseById(101);
        if (math != null) {
            attendanceService.displayAttendanceLog(math);
        }

        // Demonstrate polymorphism with school directory
        displaySchoolDirectory(registrationService);

        // Save all data
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();
        
        System.out.println("\nAll data saved to files successfully!");
    }
}