package com.demo.testing.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

public class FooTest {

	@BeforeClass
	public static void init() {
		System.out.println("@beforeClass");
	}

	@AfterClass
	public static void wrapUp() {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() {
		System.out.println("\t@Before");
	}

	@After
	public void tearDown() {
		System.out.println("\t@After");
	}

	@Test
	public void testAnother() {
		System.out.println("\t\t@Test test");
	}

	@Test
	public void testToString() {
		System.out.println("\t\t@Test another test");
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}

	@Ignore("Ignore for this testing")
	public void testIgnored() { /**/ }
}
