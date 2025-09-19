// package com.school;

// public class Main {
//     public static void main(String[] args){
//         System.out.println("Welcome to the School Attendance System Project!");
//         System.out.println("Session 1: Project Setup and Orientation Complete.");
// }


package com.school;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- School Attendance System ---");

        // Create objects for Student, Teacher, and Staff
        Student student1 = new Student("Alice", "10th Grade");
        Student student2 = new Student("Bob", "9th Grade");
        Student student3 = new Student("Charlie", "11th Grade");
        Student student4 = new Student("Dora", "12th Grade");

        Teacher teacher = new Teacher("Mr. Smith", "Mathematics");
        Staff staff = new Staff("Mrs. Johnson", "Administrator");

        // Display details for each
        System.out.println("\nDetails of Students:");
        student1.displayDetails();
        student2.displayDetails();
        student3.displayDetails();
        student4.displayDetails();

        System.out.println("\nDetails of Teacher:");
        teacher.displayDetails();

        System.out.println("\nDetails of Staff:");
        staff.displayDetails();
    }
}