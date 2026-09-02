package com.airtribe.learntrack.services;

import com.airtribe.learntrack.entities.Course;
import com.airtribe.learntrack.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private static List<Course> courses= new ArrayList<>();


    public List<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public void viewAllCourses(){
        for (Course course: courses){
            System.out.println("Course Name: "+ course.getCourseName());
            System.out.println("Course Description: "+ course.getDescription());
            System.out.println("Course Duration: "+ course.getDurationInWeeks());
            System.out.println("Course Active: "+ course.isActive());
            System.out.println("Course ID: "+ course.getId());
            System.out.println("-----------------------------");
        }
    }
    public void deactivateCourseByid(int courseId){
        for (Course course: courses){
            if(course.getId() == courseId){
                course.setActive(false);
                System.out.println("Courses "+ course.getCourseName()+" deactivated successfully");
                return;
            }
        }
        System.out.println("Course with ID "+ courseId+" not found");
    }
}
