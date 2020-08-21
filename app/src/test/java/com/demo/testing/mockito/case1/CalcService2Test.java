package com.demo.testing.mockito.case1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

public class CalcService2Test {

    // SUT
    CalcService calcService;

    @Mock
    AddService addService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalc() {
        // Arrange (Given)
        calcService = new CalcService(addService);

        int num1 = 11;
        int num2 = 12;
        int expected = 23;

        doReturn(expected).when(addService).add(num1, num2);

        // Act (When)
        int actual = calcService.calc(num1, num2);

        // Assert (Then)
        assertEquals(expected, actual);
    }
}