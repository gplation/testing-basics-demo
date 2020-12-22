package com.demo.testing.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class DivisibleBy extends TypeSafeMatcher<Integer> {

    private int divisor;

    public DivisibleBy(int divisor) {
        this.divisor = divisor;
    }

    @Override
    protected boolean matchesSafely(Integer item) {
        return item % divisor == 0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("divisible by " + divisor);
    }

    public static Matcher<Integer> divisibleBy(int divisor) {
        return new DivisibleBy(divisor);
    }
}
