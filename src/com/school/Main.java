// package com.school;

// public class Main{
//     public static void main(String[] args){
//         System.out.println("welcome to the school attence system project!");
//         System.out.println("session 1: project setup and orientation complete");
//     }
// }

package com.school;

public class Main {
    public static void main(String[] args) {
    Student[] students = new Student[2];
    students[0]= new Student();
    students[0].setDetails(1,"madhu");
    students[1] = new Student();
    students[1].setDetails(2,"hari");

    Course[] courses = new Course[2];

    courses[0] = new Course();
    courses[0].setDetails("1", "java");
    courses[1] = new Course();
    courses[1].setDetails("2", "python");

    System.out.println("Students:");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("Courses:");
        for (Course c : courses) {
            c.displayDetails();
        }
}
}