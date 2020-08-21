package com.demo.testing.calculator;

public class MetricFactory {

    public Timer createTimer(String moduleName, String methodName) {
        return new Timer();
    }
}
