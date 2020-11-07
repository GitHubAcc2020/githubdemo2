package testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import app.Calculator;

public class test1 {
	static Calculator c=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c=new Calculator();
	}

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void test1() {
		
		int result=c.sum(10, 20);
		assertEquals(30, result);
	}
	@Test
	public void test2() {
		
		int result=c.sub(10, 20);
		assertEquals(-10, result);
	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		c=null;
	}
	

}
