package com.demo.testing.junit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

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

        section = new Section(course, 2020, Semester.Fall);
    }

    @Test
    public void should_return_an_empty_student_list_if_new_section_created() {
        // Given

        // When

        // Then
        assertEquals(0, section.getStudents().size());
        assertThat(section.getStudents(), hasSize(0));
    }

    @Test
    public void should_increment_students_if_a_new_student_enrolled() {
        // Given

        // When
        section.enroll(student);

        // Then
        assertThat(section.getStudents(), hasSize(1));
    }

    @Test
    public void should_drop_an_existing_student() {
        // Given
        section.enroll(student);

        // When
        section.drop(student);

        // Then
        assertThat(section.getStudents(), hasSize(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_if_try_to_drop_unEnrolled_student() throws Exception {
        // Given
        section.enroll(student);

        // When
        section.drop(anotherStudent);

        // Then
    }

}