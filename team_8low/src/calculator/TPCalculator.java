package calculator;

import java.util.Vector;

import constants.TPConstant;
import data.TPData.EData;

public class TPCalculator {
	// attributes
	private static TPCalculator calculatorInstance;
	// components
	// associations
	// working variables
	private String[] selectedItem;
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

	public void calculate(String[] selectedItem) {
		this.selectedItem = selectedItem;
	}
	
	public void dataSort() {
	}
	
	public void courseSort() {
		
	}
	
	public EData[] getCourse() {return course;}
}
