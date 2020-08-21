package com.demo.testing.rules;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class TestRuleTest {

    @Rule
    public MyTestRule myRule = new MyTestRule();

    @Rule
    public YourTestRule yourRule = new YourTestRule();

//    @Rule
//    public TestRule compositeRule = RuleChain.outerRule(new MyTestRule())
//            .around(new YourTestRule());

    @Before
    public void setUp() throws Exception {
        System.out.println("before ...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after ...");
    }

    @Test
    public void testRule() throws Exception {
        // Arrange (Given)

        // Act (When)
        System.out.println("\ttesting ...");

        // Assert (Then)
    }
}
