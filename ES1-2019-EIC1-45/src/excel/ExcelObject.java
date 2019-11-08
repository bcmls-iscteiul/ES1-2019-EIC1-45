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

public class ExcelObject {

	private XSSFWorkbook workbook;
	private String method;
	private int loc;
	private int cyclo;
	private int atfd;
	private double laa;
	
	public ExcelObject(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public String getMethod() {
		return method;
	}

	public int getLoc() {
		return loc;
	}

	public int getCyclo() {
		return cyclo;
	}

	public int getAtfd() {
		return atfd;
	}

	public double getLaa() {
		return laa;
	}
}
