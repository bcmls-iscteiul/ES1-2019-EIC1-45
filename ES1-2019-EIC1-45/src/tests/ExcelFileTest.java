package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excel.ExcelFile;
import excel.ExcelObject;

class ExcelFileTest {

	
	ExcelFile file;
	
	@BeforeEach
	void setUp() throws Exception {
		file = new ExcelFile();
	}
	
	@Test
	void testImportFile() throws FileNotFoundException, IOException {
		ExcelFile testFile = new ExcelFile();
		assertNotEquals(file, testFile);
		
		
	}
	
	
	@Test
	void testGetExcelObjects() throws FileNotFoundException, IOException {
		ExcelFile testFile = new ExcelFile();
		assertEquals(file.getExcelObjects(), testFile.getExcelObjects());
	}
	
}
