package gui;

public class Rule {
	private String name;
	private String arg1; 
	private String arg2;
	private Double threshold1; 
	private Double threshold2;
	private Boolean greaterArg1; 
	private Boolean greaterArg2; 
	private Boolean andValue; 
	private Boolean isFeatureEnvy;
	
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

	public String getName() {
		return name;
	}

	public Double getThreshold1() {
		return threshold1;
	}

	public void setThreshold1(Double threshold1) {
		this.threshold1 = threshold1;
	}

	public Double getThreshold2() {
		return threshold2;
	}

	public void setThreshold2(Double threshold2) {
		this.threshold2 = threshold2;
	}

	public String getArg1() {
		return arg1;
	}

	public String getArg2() {
		return arg2;
	}

	public Boolean getGreaterArg1() {
		return greaterArg1;
	}

	public Boolean getGreaterArg2() {
		return greaterArg2;
	}

	public Boolean getAndValue() {
		return andValue;
	}

	public Boolean getIsFeatureEnvy() {
		return isFeatureEnvy;
	}
	
	
}
