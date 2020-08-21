package com.demo.testing.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyTestRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    System.out.println("my rule before...");

                    base.evaluate();

                    System.out.println("my rule after...");
                } finally {
                    // TODO -- close some resources
                }
            }
        };
    }
}
