package com.demo.testing.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsOnlyDigits extends TypeSafeMatcher<String> {
    /*
     * matchesSafely(T t): contains our matching logic
     */
    @Override
    protected boolean matchesSafely(String item) {
        try {
            Integer.parseInt(item);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    /*
     * customizes the message the client will get when our matching logic is not fulfilled
     */
    @Override
    public void describeTo(Description description) {

        // attaching a text that represents our expectations
        description.appendText("only digits");
    }

    /*
     * public API
     */
    public static Matcher<String> onlyDigits() {
        return new IsOnlyDigits();
    }
}
