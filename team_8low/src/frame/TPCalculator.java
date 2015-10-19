package frame;

import java.util.Vector;

import constants.TPConstant;
import data.TPData.EData;

public class TPCalculator {
	// attributes
	private static TPCalculator calculatorInstance;
	// components
	// associations
	// working variables
	private String selectedRegion, selectedTheme;
	private Vector<EData> dataPool;
	private EData[] course;
	
	private TPCalculator() {
		dataPool = new Vector<EData>();
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
		for(EData temp : EData.values()) {
			if(temp.getRegion() == selectedRegion) {
				if(temp.getTheme() == selectedTheme) {
					dataPool.add(temp);
				}
			}
		}
	}
	
	public void courseSort() {
		
	}
	
	public EData[] getCourse() {return course;}
}
