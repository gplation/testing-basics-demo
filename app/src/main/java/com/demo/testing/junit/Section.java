package com.demo.testing.junit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Section {
    private Course course;
    private int year;
    private Semester semester;

    private List<Student> students = new ArrayList<>();

    public Section(Course course, int year, Semester semester) {
        this.course = course;
        this.year = year;
        this.semester = semester;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    /* To be filled later */
}
