# madhu_S89_Attendance_management_project
README.md

## Part 1 Summary
- Project setup and orientation.
- Created initial folder structure and base files.
- Verified Java environment and basic compilation.

## Part 2 Summary
- Implemented basic Student and Course classes.
- Added methods for displaying details.
- Demonstrated object creation and method usage in Main.java.

## Part 3 Summary
- Implemented constructors for Student and Course classes.
- Automatic unique ID generation for students and courses using static variables.
- Demonstrated auto-ID by creating multiple instances in Main.java.

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to Student and Course classes by making fields private and adding public getters.
- Introduced a new AttendanceRecord class with private fields, a constructor, and getters to store attendance data.
- Implemented basic validation in the AttendanceRecord constructor for the attendance status (allowing only "Present" or "Absent").
- Used an ArrayList in Main.java to store and display AttendanceRecord objects.
- Demonstrated retrieving IDs using getters (e.g., student1.getStudentId()) when creating records.

## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy

- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

## Part 6: Interface-Driven Persistence with Storage

- Defined a `Storable` interface with a `toDataString()` method.
- Modified `Student`, `Course`, and `AttendanceRecord` classes to implement the `Storable` interface and provide their specific `toDataString()` implementations (CSV format).
- Created a `FileStorageService` class with a `saveData(List<? extends Storable> items, String filename)` method to write `Storable` objects to a text file.
- Utilized `try-with-resources` for safe file handling (`PrintWriter`, `FileWriter`).
- Demonstrated in `Main.java` how to save lists of students, courses, and attendance records to separate files (`students.txt`, `courses.txt`, `attendance_log.txt`).

## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports
- Modified `AttendanceRecord` to hold `Student` and `Course` objects instead of just their IDs, enhancing its object-oriented nature and how records are displayed. The `toDataString()` method still uses IDs for simpler file storage.
- Created a `displaySchoolDirectory(List<Person> people)` method in `Main.java` to demonstrate polymorphism. This method iterates through a list of `Person` objects (containing `Student`, `Teacher`, `Staff` instances) and calls `person.displayDetails()`. The correct overridden method for each specific object type is executed at runtime.
- Populated a `List<Person>` in `main` and used it with `displaySchoolDirectory`.
- Updated `Main.java` to use `instanceof` and casting when preparing the list of students for saving, as `Person` itself does not implement `Storable`.
- Discussed how polymorphism allows for flexible and extensible code by treating different object types uniformly through a common interface or base class reference.

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance
- Created an `AttendanceService.java` class to encapsulate attendance logic and manage the list of `AttendanceRecord` objects.
- Implemented overloaded `markAttendance` methods in `AttendanceService`:
    - `markAttendance(Student student, Course course, String status)`
    - `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` (performs lookups)
- Implemented overloaded `displayAttendanceLog` methods in `AttendanceService`:
    - `displayAttendanceLog()` (shows all records)
    - `displayAttendanceLog(Student student)` (filters by student)
    - `displayAttendanceLog(Course course)` (filters by course)
- Utilized helper methods for finding students and courses by ID.
- `AttendanceService` now uses `FileStorageService` to save its `attendanceLog`.
- Demonstrated the use of these overloaded methods in `Main.java`, showing how different method signatures allow for flexible ways to call the same conceptual operation.

## How to Run

1. Navigate to the project root directory.
2. Compile: 
   ```sh
   javac src/com/school/*.java
   ```
   (or list individual files including AttendanceRecord.java)
3. Run: 
   ```sh
   java -cp src com.school.Main
   ```
4. Check the generated files: `students.txt`, `courses.txt`, `attendance_log.txt`.

## Project Structure

```
Attendance_management_project/
├── src/
│   └── com/
│       └── school/
│           ├── Person.java
│           ├── Student.java
│           ├── Teacher.java
│           ├── Staff.java
│           ├── Course.java
│           ├── AttendanceRecord.java
│           ├── FileStorageService.java
│           └── Main.java
└── README.md
```

## Notes

- Ensure you have Java installed (java -version).
- All source files are in src/com/school/.
- Output will display registered students, available courses, and attendance records with polymorphic behavior demonstration.