 LearnTrack - Core Java Student & Course Management System

Console-based application to manage Students, Courses, and Enrollments using Core Java fundamentals.

 Features
- Student management (add, view, search, deactivate)
- Course management (add, view, activate/deactivate)
- Enrollment management (enroll, view by student, update status)
 Tech
- Java (Core Java)
- ArrayList (in-memory storage)
 Compile & Run

javac -d out src/com/airtribe/learntrack/**/*.java
java -cp out com.airtribe.learntrack.ui.Main


Class Diagram (Mermaid)
```mermaid
classDiagram
    Person <|-- Student
    class Person{
      -int id
      -String firstName
      -String lastName
      -String email
      +getDisplayName()
    }
    class Student{
      -String batch
      -boolean active
    }
    class Course{
      -int id
      -String courseName
      -String description
      -int durationInWeeks
      -boolean active
    }
    class Enrollment{
      -int id
      -int studentId
      -int courseId
      -LocalDate enrollmentDate
      -EnrollmentStatus status
    }
