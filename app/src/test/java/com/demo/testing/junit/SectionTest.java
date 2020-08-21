package com.demo.testing.junit;

import org.junit.Before;
import org.junit.Test;

public class SectionTest {

    // SUT
    private Section section;

    private Student student;
    private Student anotherStudent;
    private Course course;

    @Before
    public void setUp() {
        course = new Course("ComSci", "cse201", 3);
        student = new Student("S001");
        anotherStudent = new Student("S002");
    }

    @Test
    public void should_return_an_empty_student_list_if_new_section_created() {
        // Given

        // When

        // Then
    }

    @Test
    public void should_increment_students_if_a_new_student_enrolled() {
        // Given

        // When

        // Then
    }

    @Test
    public void should_drop_an_existing_student() {
        // Given

        // When

        // Then
    }

    public void should_throw_exception_if_try_to_drop_unEnrolled_student() throws Exception {
        // Given

        // When

        // Then
    }

}