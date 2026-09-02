

import com.airtribe.learntrack.entities.*;
import com.airtribe.learntrack.exceptions.EntityNotFound;

import com.airtribe.learntrack.services.*;

import com.airtribe.learntrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== LearnTrack Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Activate/Deactivate Course");
            System.out.println("8. Enroll Student in Course");
            System.out.println("9. View Enrollment by Student");
            System.out.println("10. Update Enrollment Status");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("First Name: "); String fn = sc.nextLine();
                        System.out.print("Last Name: "); String ln = sc.nextLine();
                        System.out.print("Email: "); String email = sc.nextLine();
                        System.out.print("Batch: "); String batch = sc.nextLine();

                        Student st = new Student(IdGenerator.getNextStudentId(), fn, ln, email, batch, true);
                        studentService.addStudent(st);
                        System.out.println("Student added: " + st);
                        break;

                    case 2:
                        studentService.viewAllStudents();
                        break;

                    case 3:
                        System.out.print("Student ID: ");
                        Student student = studentService.searchByID(Integer.parseInt(sc.nextLine()));
                        System.out.println("Student ID " +
                                student.getId() +
                                ": " +
                                student.getDisplayName() +
                                " [Batch: " + student.getBatch()
                                + "] [Active: " +
                                student.isActive() + "]");
                        break;

                    case 4:
                        System.out.print("Student ID to deactivate: ");
                        studentService.deactivateStudent(Integer.parseInt(sc.nextLine()));
                        System.out.println("Student deactivated.");
                        break;

                    case 5:
                        System.out.print("Course Name: "); String cn = sc.nextLine();
                        System.out.print("Description: "); String desc = sc.nextLine();
                        System.out.print("Duration (weeks): "); int weeks = Integer.parseInt(sc.nextLine());

                        Course c = new Course(desc,IdGenerator.getNextCourseId(), cn, weeks, true);
                        courseService.addCourse(c);
                        System.out.println("Course added: " + c);
                        break;

                    case 6:
                        courseService.viewAllCourses();
                        break;

                    case 7:
                        System.out.print("Course ID: "); int cid = Integer.parseInt(sc.nextLine());
                        System.out.print("Set active? (true/false): "); boolean active = Boolean.parseBoolean(sc.nextLine());
                        courseService.deactivateCourseByid(cid);
                        System.out.println("Course updated.");
                        break;

                    case 8:
                        System.out.print("Student ID: "); int sid = Integer.parseInt(sc.nextLine());
                        studentService.searchByID(sid);
                        System.out.print("Course ID: "); int coid = Integer.parseInt(sc.nextLine());

                        Enrollment e = new Enrollment(IdGenerator.getNextEnrollmentId(), sid, coid, LocalDate.now(),"ACTIVE");
                        enrollmentService.enrollStudents(new Student(sid, "Lokesh", "lokeshkv789@gmail.com", "k", "2", true), coid);
                        System.out.println("Enrollment created: " + e);
                        break;

                    case 9:
                        System.out.print("Student ID: "); int studentId = Integer.parseInt(sc.nextLine());
                         enrollmentService.viewStudentEnrollments(studentId);

                        break;

                    case 10:
                        System.out.print("Enter ID to Deactivate. Enrollment ID: "); int eid = Integer.parseInt(sc.nextLine());

                        enrollmentService.enrollmentStatus(eid);
                        System.out.println("Enrollment status updated.");
                        break;

                    case 0:
                        running = false;
                        System.out.println("Exiting LearnTrack...");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose from menu.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number input. Please enter valid numeric values.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid enum/status input. Use ACTIVE, COMPLETED, CANCELLED.");
            } catch (EntityNotFound ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Unexpected error: " + ex.getMessage());
            }
        }

        sc.close();
    }
}