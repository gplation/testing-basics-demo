package com.demo.testing.junit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Student {
    private String id;
    private Map<Course, Double> scores = new HashMap<>();

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Map<Course, Double> getScores() {
        return Collections.unmodifiableMap(scores);
    }

    public void setScore(Course course, double score) {
        scores.put(course, score);
    }

    public Optional<Double> getScore(Course course) {
        return Optional.ofNullable(scores.get(course));
    }
}
