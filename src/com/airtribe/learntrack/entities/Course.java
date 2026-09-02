package com.airtribe.learntrack.entities;

public class Course {

    private String courseName;
    private int id;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public int getId() {
        return id;
    }

    public Course(String description, int id, String courseName, int durationInWeeks, boolean active) {
        this.description = description;
        this.id = id;
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
