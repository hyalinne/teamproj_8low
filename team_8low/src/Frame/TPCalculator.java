package Frame;

import constants.TPConstant;
import data.TPData.EData;

public class TPCalculator {
	// attributes
	// components
	// associations
	// working variables
	private static TPCalculator calculatorInstance;
	private String selectedRegion, selectedTheme;
	private EData[] course;
	
	private TPCalculator() {
		course = new EData[TPConstant.COURSE_NUM];
	}
	
	public static TPCalculator getInstance() {
		if(calculatorInstance == null) {
			calculatorInstance = new TPCalculator();
		}
		return calculatorInstance;
	}

	public void calculate(String selectedRegion, String selectedTheme) {
		this.selectedRegion = selectedRegion;
		this.selectedTheme = selectedTheme;
	}
	
	public void dataSort() {
		
	}
	
	public void courseSort() {
		
	}
	
	public EData[] getCourse() {return course;}
}
