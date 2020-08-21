package com.demo.testing.rules;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class YourTestRule extends TestWatcher {

    @Override
    protected void starting(Description description) {
        System.out.println("your rule before...");
    }

    @Override
    protected void finished(Description description) {
        System.out.println("your rule after...");
    }
}
