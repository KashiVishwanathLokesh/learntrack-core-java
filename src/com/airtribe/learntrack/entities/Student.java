package com.airtribe.learntrack.entities;

public class Student extends Person {

    private String batch;
    private boolean active;


    public Student(  int id, String name, String email,  String lastName,String batch, boolean active) {
        super(id, name,lastName, email );
        this.batch = batch;
        this.active = active;
    }

    @Override
    public String getDisplayName() {
        return "Student: " + super.getDisplayName() + " [Batch: " + batch + "]";
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
