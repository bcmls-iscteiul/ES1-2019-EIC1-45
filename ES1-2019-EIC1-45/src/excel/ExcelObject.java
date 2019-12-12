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

/** This class represents a line of the excel file.
 * 
 * @author Frederico Correia
 * @author Nuno Rego
 *
 */
public class ExcelObject {
	/**
	 * Value of the row MethodID of the Excel file
	 */
	private double id;
	
	/**
	 * Value of the row package of the Excel file
	 */
	private String pckage;
	/**
	 * Value of the row class of the Excel file
	 */
	private String clss;
	/**
	 * Value of the row method of the Excel file
	 */
	private String method;
	
	/**
	 * Value of the row LOC of the Excel file
	 */
	private double loc;
	/**
	 * Value of the row CYCLO of the Excel file
	 */
	private double cyclo;
	/**
	 * Value of the row ATFD of the Excel file
	 */
	private double atfd;
	/**
	 * Value of the row LAA of the Excel file
	 */
	private double laa;
	
	/**
	 * Value of the row is_long_method of the Excel file
	 */
	private boolean is_long_method;
	/**
	 * Value of the row iPlasma of the Excel file
	 */
	private boolean iPlasma;
	/**
	 * Value of the row PMD of the Excel file
	 */
	private boolean PMD;
	/**
	 * Value of the row is_feature_envy of the Excel file
	 */
	private boolean is_feature_envy;
	
	/**Creates a new ExcelObject
	 * 
	 * @param id MethodID value is a double
	 * @param pckage package value is a String
	 * @param clss class value is a String
	 * @param method method value is a double
	 * @param loc LOC value is a double
	 * @param cyclo CYCLO value is a double
	 * @param atfd ATFD value is a double
	 * @param laa LAA value is a double
	 * @param is_long_method is_long_method value is a boolean
	 * @param iPlasma iPlasma value is a boolean
	 * @param PMD PMD value is a boolean
	 * @param is_feature_envy is_feature_envy value is a boolean
	 */
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
	
	/**Creates an empty ExcelObject
	 * 
	 */
	public ExcelObject() {
		
	}
	
	/**
	 * 
	 * @return MethodID value
	 */
	public double getId() {
		return id;
	}
	
	/**Sets MethodID with given value
	 * 
	 * @param id MethodID value to set
	 */
	public void setId(double id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return package value
	 */
	public String getPckage() {
		return pckage;
	}
	
	/**Sets package with given value
	 * 
	 * @param pckage package value to set
	 */
	public void setPckage(String pckage) {
		this.pckage = pckage;
	}
	
	/**
	 * 
	 * @return class value
	 */
	public String getClss() {
		return clss;
	}
	
	/**Sets class with given value
	 * 
	 * @param clss class value to set
	 */
	public void setClss(String clss) {
		this.clss = clss;
	}
	
	/**
	 * 
	 * @return method value
	 */
	public String getMethod() {
		return method;
	}
	
	/**Sets method with given value
	 * 
	 * @param method method value to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * 
	 * @return LOC value
	 */
	public double getLoc() {
		return loc;
	}
	
	/**Sets LOC with given value
	 * 
	 * @param loc LOC value to set
	 */
	public void setLoc(double loc) {
		this.loc = loc;
	}
	
	/**
	 * 
	 * @return CYCLO value
	 */
	public double getCyclo() {
		return cyclo;
	}
	
	/**Sets CYCLO with given value
	 * 
	 * @param cyclo CYCLO value to set
	 */
	public void setCyclo(double cyclo) {
		this.cyclo = cyclo;
	}
	
	/**
	 * 
	 * @return ATFD value
	 */
	public double getAtfd() {
		return atfd;
	}
	
	/**Sets ATFD with given value
	 * 
	 * @param atfd ATFD value to set
	 */
	public void setAtfd(double atfd) {
		this.atfd = atfd;
	}
	
	/**
	 * 
	 * @return LAA value
	 */
	public double getLaa() {
		return laa;
	}
	
	/**Sets LAA to double given a String value
	 * 
	 * @param laa LAA String value to parse to double
	 */
	public void setLaa(String laa) {
		this.laa = Double.parseDouble(laa);
	}
	
	/**Sets LAA with given value
	 * 
	 * @param laa LAA value to set
	 */
	public void setLaa(Double laa) {
		this.laa = laa;
	}
	
	/**
	 * 
	 * @return is_long_method value
	 */
	public boolean isIs_long_method() {
		return is_long_method;
	}

	/**Sets is_long_method with given value
	 * 
	 * @param is_long_method is_long_method value to set
	 */
	public void setIs_long_method(boolean is_long_method) {
		this.is_long_method = is_long_method;
	}
	
	/**
	 * 
	 * @return iPlasma value
	 */
	public boolean isiPlasma() {
		return iPlasma;
	}
	
	/**Sets iPlasma with given value
	 * 
	 * @param iPlasma iPlasma value to set
	 */
	public void setiPlasma(boolean iPlasma) {
		this.iPlasma = iPlasma;
	}
	
	/**
	 * 
	 * @return PMD value
	 */
	public boolean isPMD() {
		return PMD;
	}
	
	/**Sets PMD with given value
	 * 
	 * @param pMD PMD value to set
	 */
	public void setPMD(boolean pMD) {
		PMD = pMD;
	}
	
	/**
	 * 
	 * @return is_feature_envy value
	 */
	public boolean isIs_feature_envy() {
		return is_feature_envy;
	}
	
	/**Sets is_feature_envy with given value
	 * 
	 * @param is_feature_envy is_feture_envy value to sets
	 */
	public void setIs_feature_envy(boolean is_feature_envy) {
		this.is_feature_envy = is_feature_envy;
	}
	
	public boolean[] defineIndicators(ExcelObject obj) {
		boolean[] values = new boolean[4];
		if((this.isiPlasma() || this.isPMD()) && this.is_long_method) 
			values[0]=true;
		if((this.isiPlasma() || this.isPMD()) && !this.is_long_method)
			values[1]=true;
		if((!this.isiPlasma() || !this.isPMD()) && !this.is_long_method)
			values[2]=true;
		if((!this.isiPlasma() || !this.isPMD()) && this.is_long_method)
			values[3]=true;
		return values;
	}
	
	public boolean[] defineIndicators(boolean iPlasma, boolean PMD, boolean is_Long_Method) {
		boolean[] values = new boolean[4];
		if((iPlasma || PMD) && is_long_method) 
			values[0]=true;
		if((iPlasma ||PMD) && !is_long_method)
			values[1]=true;
		if((!iPlasma || !PMD) && !is_long_method)
			values[2]=true;
		if((!iPlasma || !PMD) && is_long_method)
			values[3]=true;
		return values;
	}
	
	/**
	 * 
	 * @return a string following the format "ExcelObject [id=id]"
	 */
	@Override
	public String toString() {
		return "ExcelObject [id=" + id + "]";
	}
	
	
	
}
