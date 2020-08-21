package com.demo.testing.matchers;

import org.junit.Test;

import static com.demo.testing.matchers.IsOnlyDigits.onlyDigits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class CustomMatchersTest {

    @Test
    public void givenAString_whenIsOnlyDigits_thenCorrect() {
        String digits = "1234";

        assertThat(digits, onlyDigits());
    }

    @Test
    public void givenAString_whenNotIsOnlyDigits_thenIncorrect() {
        String digits = "abc1234";

        assertThat(digits, is(not(onlyDigits())));
    }

    @Test
    public void givenAnEvenInteger_whenDivisibleByTwo_thenCorrect() {
        Integer ten = 10;
        Integer two = 2;

//        assertThat(ten, is(divisibleBy(two)));
    }

    @Test
    public void givenAnOddInteger_whenNotDivisibleByTwo_thenCorrect() {
        Integer eleven = 11;
        Integer two = 2;

//        assertThat(eleven, is(not(divisibleBy(two))));
    }
}
