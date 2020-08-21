package com.demo.testing.mockito.case1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class SpyTest {

    @Test
    public void testMethod() {
        // Arrange (Given)
        List<String> list = new ArrayList<>();
        List<String> listSpy = spy(list);

        // Act (When)
        listSpy.add("first-element");

        // Assert (Then)
        assertEquals("first-element", listSpy.get(0));

        // Act (When) -- be careful!
        when(listSpy.get(0)).thenReturn("second-element");

        // Assert (Then)
        assertEquals("second-element", listSpy.get(0));
    }
}
