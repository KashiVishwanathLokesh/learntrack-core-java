package com.airtribe.learntrack.services;

import com.airtribe.learntrack.entities.Enrollment;
import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {



    public  static List<Enrollment> enrolledStudents = new ArrayList<>();

    public void enrollStudents(Student student, int courseId){
        Enrollment enrollment = new Enrollment(IdGenerator.getNextEnrollmentId(),student.getId(), courseId, java.time.LocalDate.now(), "ACTIVE");
        enrolledStudents.add(enrollment);
        System.out.println("Student "+ student.getId()+" enrolled successfully in course ID "+ courseId+ " with enrollment ID "+ enrollment.getId());
    }


    public void viewStudentEnrollments(int studentId){
        System.out.println("Enrollments for Student ID: "+ studentId);
        for (Enrollment enrollment: enrolledStudents){
            if(enrollment.getStudentId() == studentId){
                System.out.println("Enrollment ID: "+ enrollment.getId());
                System.out.println("Course ID: "+ enrollment.getCourseId());
                System.out.println("Enrollment Date: "+ enrollment.getEnrollmentDate());
                System.out.println("Status: "+ enrollment.getStatus());
                System.out.println("-----------------------------");
            }
        }
    }

    public void enrollmentStatus(int enrollmentId){
        for (Enrollment enrollment: enrolledStudents){
            if(enrollment.getId() == enrollmentId){
                enrollment.setStatus("COMPLETED");
                System.out.println("Enrollment ID "+ enrollmentId+" marked as COMPLETED");
                return;
            }
        }
        System.out.println("Enrollment ID "+ enrollmentId+" not found");
    }
}
