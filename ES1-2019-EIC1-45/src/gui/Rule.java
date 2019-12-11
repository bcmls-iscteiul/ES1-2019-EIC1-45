package gui;

public class Rule {
	
	private String arg1; 
	private String arg2;
	private Double threshold1; 
	private Double threshold2;
	private Boolean greaterArg1; 
	private Boolean greaterArg2; 
	private Boolean andValue; 
	private Boolean isFeatureEnvy;
	
	public Rule(String arg1, String arg2, Double threshold1, Double threshold2, Boolean greaterArg1,
			Boolean greaterArg2, Boolean andValue, Boolean isFeatureEnvy) {
		super();
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.threshold1 = threshold1;
		this.threshold2 = threshold2;
		this.greaterArg1 = greaterArg1;
		this.greaterArg2 = greaterArg2;
		this.andValue = andValue;
		this.isFeatureEnvy = isFeatureEnvy;
	}
	
	
}
