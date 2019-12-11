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

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**This class represents the Excel File
 * 
 * @author Frederico Correia
 * @author Nuno Rego
 *
 */
public class ExcelFile {
	
	/**
	 * Path to the excel file
	 */
	private static String DIRECTORY="src/Long-Method.xlsx";
	
	/**
	 * Variable that will let us read a store the information of the Excel file with its methos (class is imported from foreign POI API)
	 */
	private XSSFWorkbook workbook;
	/**
	 * List of every ExcelObject in the file
	 */
	private List<ExcelObject> list = new ArrayList<>();
	
	private int[] indicators = new int[4];
	
	/**Creates a new ExcelFile
	 * 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public ExcelFile() throws FileNotFoundException, IOException {
		importFile();
	}

	/**This method will import the excel file and create ExcelObjects for each line of the file adding them all into a list
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void importFile() throws FileNotFoundException, IOException {
		// Create Workbook instance holding reference to .xlsx file
		this.workbook = new XSSFWorkbook(new FileInputStream(DIRECTORY));
		System.out.println("Novo workbook: " + workbook);
		
		// Then store every line in the excel, which represents a method of the Excel File, in the ArrayList
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		System.out.println("Selected sheet: " + sheet.getSheetName());
		int i = 1;
		
		for (Row row : sheet) {
			if (i != 1 && i < 422) {
				
				ExcelObject r = new ExcelObject();
				r.setId(row.getCell(0).getNumericCellValue());
				r.setPckage(row.getCell(1).getStringCellValue());
				r.setClss(row.getCell(2).getStringCellValue());
				r.setMethod(row.getCell(3).getStringCellValue());
				r.setLoc(row.getCell(4).getNumericCellValue());
				r.setCyclo(row.getCell(5).getNumericCellValue());
				r.setAtfd(row.getCell(6).getNumericCellValue());
				
				try {
					r.setLaa(row.getCell(7).getNumericCellValue());
				} catch(IllegalStateException e) {
					r.setLaa(row.getCell(7).getStringCellValue());
				}
				
				r.setIs_long_method(row.getCell(8).getBooleanCellValue());
				r.setiPlasma(row.getCell(9).getBooleanCellValue());
				r.setPMD(row.getCell(10).getBooleanCellValue());
				r.setIs_feature_envy(row.getCell(11).getBooleanCellValue());
				
				setIndicators(r);
				
				System.out.println("Created excel object: " + r);
				list.add(r);
			}
			
			i++;
		}
	}
	
	/**
	 * 
	 * @return list of ExcelObjects
	 */
	public List<ExcelObject> getExcelObjects() {
		return this.list;
	}
	
	public void setIndicators(ExcelObject obj) {
		boolean[] result = obj.defineIndicators(obj);
		for(int i=0; i<4; i++) {
			if(result[i]) {
				indicators[i] ++;
			}
		}
	}
	public static void main(String args[]) throws FileNotFoundException, IOException {
		ExcelFile f = new ExcelFile();
		f.importFile();
	}
}
