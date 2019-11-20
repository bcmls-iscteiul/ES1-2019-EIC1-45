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

// This class represents a line in the excel file - a method.
public class ExcelObject {

	private double id;
	
	private String pckage;
	private String clss;
	private String method;
	
	private double loc;
	private double cyclo;
	private double atfd;
	private double laa;
	
	private boolean is_long_method;
	private boolean iPlasma;
	private boolean PMD;
	private boolean is_feature_envy;
	
	public ExcelObject(double id, String pckage, String clss, String method, double  loc, double cyclo, double atfd, double laa,
			boolean is_long_method, boolean iPlasma, boolean PMD, boolean is_feature_envy) {
		
		this.id = id;
		this.pckage = pckage;
		this.clss = clss;
		this.method = method;
		this.loc = loc;
		this.cyclo = cyclo;
		this.atfd = atfd;
		this.laa = laa;
		this.is_long_method = is_long_method;
		this.iPlasma = iPlasma;
		this.PMD = PMD;
		this.is_feature_envy = is_feature_envy;
	}
	
	public ExcelObject() {
		
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getPckage() {
		return pckage;
	}

	public void setPckage(String pckage) {
		this.pckage = pckage;
	}

	public String getClss() {
		return clss;
	}

	public void setClss(String clss) {
		this.clss = clss;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public double getLoc() {
		return loc;
	}

	public void setLoc(double loc) {
		this.loc = loc;
	}

	public double getCyclo() {
		return cyclo;
	}

	public void setCyclo(double cyclo) {
		this.cyclo = cyclo;
	}

	public double getAtfd() {
		return atfd;
	}

	public void setAtfd(double atfd) {
		this.atfd = atfd;
	}

	public double getLaa() {
		return laa;
	}

	public void setLaa(String laa) {
		this.laa = Double.parseDouble(laa);
	}
	
	public void setLaa(Double laa) {
		this.laa = laa;
	}

	public boolean isIs_long_method() {
		return is_long_method;
	}

	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}

	public boolean isiPlasma() {
		return iPlasma;
	}

	public void setiPlasma(boolean iPlasma) {
		this.iPlasma = iPlasma;
	}

	public boolean isPMD() {
		return PMD;
	}

	public void setPMD(boolean pMD) {
		PMD = pMD;
	}

	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}

	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}
	
	@Override
	public String toString() {
		return "ExcelObject [id=" + id + "]";
	}
	
	
	
}
