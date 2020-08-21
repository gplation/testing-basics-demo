package com.demo.testing.junit;

public class Course {
    private String department;
    private String number;
    private int credits;

    public Course(String department, String number, int credits) {
        this.department = department;
        this.number = number;
        this.credits = credits;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
