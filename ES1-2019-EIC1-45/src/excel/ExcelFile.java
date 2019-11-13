package excel;

import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	private String path;
	private XSSFWorkbook workbook;
	private ExcelObject object;
	private List<ExcelObject> list = new ArrayList<>();

	public ExcelFile(String path) throws FileNotFoundException, IOException {
		this.path = path;
	}

	// This method will simply import the excel file, given it's location, into the
	public void importFile() throws FileNotFoundException, IOException {
		// Create Workbook instance holding reference to .xlsx file
		this.workbook = new XSSFWorkbook(new FileInputStream(path));
		
		// Then store every line in the excel, which represents a method of the Excel File, in the ArrayList
		
		
		
	}
}
