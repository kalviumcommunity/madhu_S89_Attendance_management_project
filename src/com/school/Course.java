package com.school;

public class Course {
     String courseID;
     String courseName;

     public void setDetails(String id, String CName){
        this.courseID=id;
        this.courseName=CName;
     }

     public void displayDetails(){
        System.out.println("Course ID: "+this.courseID+", Name: "+ this.courseName);
     }
}
