// package com.school;

// public class Main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the School Attendance System Project!");
//         System.out.println("Session 1: Project Setup and Orientation Complete.");
// }


package com.school;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create and populate lists
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "10th Grade"));
        students.add(new Student("Bob", "9th Grade"));
        students.add(new Student("Charlie", "11th Grade"));
        students.add(new Student("Dora", "12th Grade"));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Science"));

        ArrayList<AttendanceRecord> records = new ArrayList<>();
        records.add(new AttendanceRecord(1, 101, "Present"));
        records.add(new AttendanceRecord(2, 102, "Absent"));

        // Save data to files
        FileStorageService storageService = new FileStorageService();
        storageService.saveData(students, "students.txt");
        storageService.saveData(courses, "courses.txt");
        storageService.saveData(records, "attendance_log.txt");
    }
}