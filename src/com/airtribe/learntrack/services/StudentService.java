package com.airtribe.learntrack.services;

import com.airtribe.learntrack.entities.Student;
import com.airtribe.learntrack.exceptions.EntityNotFound;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

private static List<Student> students= new ArrayList<>();



    public StudentService() {
    }
    public StudentService(List<Student> students) {
        this.students = students;
    }

   public void addStudent(Student student){

        students.add(student);
    }

    public void viewAllStudents(){
        for(Student student: students){
            System.out.println(student.getDisplayName()+": "+student.getEmail()+" [Batch: "+student.getBatch()+"]"+" [Active: "+student.isActive()+"]");
        }
    }

    public void AddAllStudents(List<Student> students){
        this.students.addAll(students);
    }
    public Student searchByID(int id) throws EntityNotFound {

        for(Student student: students){
            if(student.getId()==id){
                return student;
            }
        }
        throw new EntityNotFound("Student with ID "+id+" not found");
    }
    public void deactivateStudent(int id) throws EntityNotFound {
     searchByID(id).setActive(false);
    }
}
