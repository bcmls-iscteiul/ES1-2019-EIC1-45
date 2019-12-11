package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excel.ExcelObject;

class ExcelObjectTest {

	ExcelObject obj;
	
	@BeforeEach
	void setUp() throws Exception {
		obj = new ExcelObject(1 ,"testPackage","testClass", "testMethod", 1, 1, 1, 1, false, false, false, false);
	}
	
	@Test
	void testGetId() {
		assertEquals(obj.getId(),1);
		assertNotEquals(obj.getId(),2);
	}
	
	@Test
	void testSetId() {
		obj.setId(3);
		assertEquals(obj.getId(),3);
	}
	
	@Test
	void testGetPckage() {
		assertEquals(obj.getPckage(),"testPackage");
		assertNotEquals(obj.getPckage(),"test");
	}
	
	@Test
	void testSetPckage() {
		obj.setPckage("default");
		assertEquals(obj.getPckage(),"default");
	}
	
	@Test
	void testGetClss() {
		assertEquals(obj.getClss(),"testClass");
		assertNotEquals(obj.getClss(),"test");
	}
	
	@Test
	void testSetClss() {
		obj.setClss("default");
		assertEquals(obj.getClss(),"default");
	}

	@Test
	void testGetMethod() {
		assertEquals(obj.getMethod(),"testMethod");
		assertNotEquals(obj.getMethod(),"import");
	}
	
	@Test
	void testSetMethod() {
		obj.setMethod("import");
		assertEquals(obj.getMethod(),"import");
	}

	@Test
	void testGetLoc() {
		assertEquals(obj.getLoc(),1);
		assertNotEquals(obj.getLoc(),2);
	}
	
	@Test
	void testSetLoc() {
		obj.setLoc(3);
		assertEquals(obj.getLoc(),3);
	}
	
	@Test
	void testGetCyclo() {
		assertEquals(obj.getCyclo(),1);
		assertNotEquals(obj.getCyclo(),2);
	}
	
	@Test
	void testSetCyclo() {
		obj.setCyclo(3);
		assertEquals(obj.getCyclo(),3);
	}
	
	@Test
	void testGetAtfd() {
		assertEquals(obj.getAtfd(),1);
		assertNotEquals(obj.getAtfd(),2);
	}
	
	@Test
	void testSetAtfd() {
		obj.setAtfd(3);
		assertEquals(obj.getAtfd(),3);
	}

	@Test
	void testGetLaa() {
		assertEquals(obj.getLaa(),1);
		assertNotEquals(obj.getLaa(),2);
	}
	
	@Test
	void testSetLaaDouble() {
		obj.setLaa(3.0);
		assertEquals(obj.getLaa(),3.0);
	}
	
	@Test
	void testSetLaaString() {
		obj.setLaa("3");
		assertEquals(obj.getLaa(),3);
	}
	
	@Test
	void testIs_long_method() {
		assertEquals(obj.isIs_long_method(), false);
	}

	@Test
	void testSetIs_long_method() {
		obj.setIs_long_method(true);
		assertEquals(obj.isIs_long_method(), true);
	}

	@Test
	void testIPlasma() {
		assertEquals(obj.isiPlasma(), false);
	}

	@Test
	void testSetIPlasma() {
		obj.setiPlasma(true);
		assertEquals(obj.isiPlasma(), true);
	}

	@Test
	void testIsPMD() {
		assertEquals(obj.isPMD(), false);
	}

	@Test
	void testSetPMD() {
		obj.setPMD(true);
		assertEquals(obj.isPMD(), true);
	}

	@Test
	void testIs_feature_envy() {
		assertEquals(obj.isIs_feature_envy(), false);
	}

	@Test
	void testSetIs_feature_envy() {
		obj.setIs_feature_envy(true);
		assertEquals(obj.isIs_feature_envy(), true);
	}

	@Test
	void testToString() {
		assertEquals(obj.toString(), "ExcelObject [id=1.0]");
	}
}

