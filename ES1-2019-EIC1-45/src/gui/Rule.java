package gui;

/**This class represents a rule to test the metrics of the excel file
 *
 * 
 * @author Frederico Corriea
 * @author Bernardo Sequeira
 *
 */
public class Rule {
	/**
	 * Name of the rule
	 */
	private String name;
	/**
	 * value that the user gives to argument 1 in the GUI
	 */
	private String arg1; 
	/**
	 * value that the user gives to argument 2 in the GUI
	 */
	private String arg2;
	/**
	 * value that the user gives to threshold1 in the GUI
	 */
	private Double threshold1; 
	/**
	 *  value that the user gives to threshold1 in the GUI
	 */
	private Double threshold2;
	 /**
	  *  value that is '<' or '>' depending on the choice of the user in the GUI
	  */
	private Boolean greaterArg1;
	/**
	 * value tha is '<' or '>' depending on the choice of the user in the GUI
	 */
	private Boolean greaterArg2; 
	/**
	 * value that is true if user chooses long_method in the GUI and false otherwise
	 */
	private Boolean andValue;
	/**
	 * value that is true if user chooses is_feature_envy in the GUI and false otherwise
	 */
	private Boolean isFeatureEnvy;
	
	/**Creates a new Rule
	 * 
	 * @param name Name of Rule
	 * @param arg1 Value that the user inputs in arg1 in the GUI
	 * @param arg2 Value that the user inputs in arg2 in the GUI
	 * @param threshold1 Value that the user inputs in threshold1 in the GUI
	 * @param threshold2 Value that the user inputs in threshold2 in the GUI
	 * @param greaterArg1 '<' or '>' depending on the user choice in the GUI
	 * @param greaterArg2 '<' or '>' depending on the user choice in the GUI
	 * @param andValue true if user chooses long_method in the GUI and false otherwise
	 * @param isFeatureEnvy true if user chooses is_feature_envy in the GUI and false otherwise
	 */
	public Rule(String name,String arg1, String arg2, Double threshold1, Double threshold2, Boolean greaterArg1,
			Boolean greaterArg2, Boolean andValue, Boolean isFeatureEnvy) {
		this.name = name;
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.threshold1 = threshold1;
		this.threshold2 = threshold2;
		this.greaterArg1 = greaterArg1;
		this.greaterArg2 = greaterArg2;
		this.andValue = andValue;
		this.isFeatureEnvy = isFeatureEnvy;
	}
	
	/**
	 * 
	 * @return Rule name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return threshold1 value
	 */
	public Double getThreshold1() {
		return threshold1;
	}
	
	/**Sets threshold1 with give value
	 * 
	 * @param threshold1 value to set
	 */
	public void setThreshold1(Double threshold1) {
		this.threshold1 = threshold1;
	}
	
	/**
	 * 
	 * @return threshold2 value
	 */
	public Double getThreshold2() {
		return threshold2;
	}
	
	/**Sets threshold2 with give value
	 * 
	 * @param threshold2 value to set
	 */
	public void setThreshold2(Double threshold2) {
		this.threshold2 = threshold2;
	}
	
	/**
	 * 
	 * @return arg1 value
	 */
	public String getArg1() {
		return arg1;
	}
	
	/**
	 * 
	 * @return arg2 value
	 */
	public String getArg2() {
		return arg2;
	}
	
	/**
	 * 
	 * @return greaterArg1 value
	 */
	public Boolean getGreaterArg1() {
		return greaterArg1;
	}
	
	/**
	 * 
	 * @return greaterArg2 value
	 */
	public Boolean getGreaterArg2() {
		return greaterArg2;
	}

	/**
	 * 
	 * @return andValue value
	 */
	public Boolean getAndValue() {
		return andValue;
	}

	/**
	 * 
	 * @return isFetureEnvy value
	 */
	public Boolean getIsFeatureEnvy() {
		return isFeatureEnvy;
	}
	
	
}
