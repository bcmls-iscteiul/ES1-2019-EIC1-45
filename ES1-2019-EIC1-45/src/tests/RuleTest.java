package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excel.ExcelObject;
import gui.Rule;

class RuleTest {

	Rule rule;
	
	@BeforeEach
	void setUp() throws Exception {
		rule = new Rule("testname" ,"testarg1","testarg2", 1.0, 1.0, false, false, false, false);
	}
	
	@Test
	void testGetName() {
		assertEquals(rule.getName(), "testname");
		assertNotEquals(rule.getName(),"name");
	}
	@Test
	void testGetThreshold1() {
		assertEquals(rule.getThreshold1(), 1.0);
		assertNotEquals(rule.getThreshold1(),2.0);
	}
	@Test
	void testSetThreshold1() {
		rule.setThreshold1(2.0);
		assertEquals(rule.getThreshold1(),2.0);
	}
	@Test
	void testGetThreshold2() {
		assertEquals(rule.getThreshold2(), 1.0);
		assertNotEquals(rule.getThreshold2(),2.0);
	}
	@Test
	void testSetThreshold2() {
		rule.setThreshold2(2.0);
		assertEquals(rule.getThreshold2(),2.0);
	}
	
	@Test
	void testGetArg1() {
		assertEquals(rule.getArg1(), "testarg1");
		assertNotEquals(rule.getArg1(),"name");
	}
	
	@Test
	void testGetArg2() {
		assertEquals(rule.getArg2(), "testarg2");
		assertNotEquals(rule.getArg2(),"name");
	}
	
	@Test
	void testGetGreaterArg1() {
		assertEquals(rule.getGreaterArg1(), false);
	}
	
	@Test
	void testGetGreaterArg2() {
		assertEquals(rule.getGreaterArg2(), false);
	}
	
	@Test
	void testAndValue() {
		assertEquals(rule.getAndValue(), false);
	}
	
	@Test
	void testGetIsFeautureEnvy() {
		assertEquals(rule.getIsFeatureEnvy(), false);
	}

}
