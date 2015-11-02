package calculator;

import constants.TPConstant;
import data.TPData.EData;

public class TPCalculator {
	// attributes
	private static TPCalculator calculatorInstance;
	// components
	private EData[] eatingPool;
	private EData[] seeingPool;
	private EData[] sleepingPool;
	private EData[][] course;
	// associations
	// working variables
	private String[] selectedItem;
	
	private TPCalculator() {
		// attributes initialization
		// components initialization
		eatingPool = new EData[20];
		seeingPool = new EData[20];
		sleepingPool = new EData[20];
		course = new EData[TPConstant.COURSE_NUM][TPConstant.CHANGE_NUM];
	}
	
	public void init() {
		// associations initialization;
		// working variable initialization
	}
	
	public static TPCalculator getInstance() {
		if(calculatorInstance == null) {
			calculatorInstance = new TPCalculator();
		}
		return calculatorInstance;
	}

	public void calculate(String[] selectedItem) {
		this.selectedItem = selectedItem;
		this.dataSort();
		this.courseSort();
	}
	
	public void dataSort() {
		// mainRegion & subRegion 에서 Data를 가져와서 Theme 에 따라 pool 에 저장
		
	}
	
	public void courseSort() {
		if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.EATING) {
		} else if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.SEEING) {
		} else if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.SLEEPING) {
		} else {
			// Testing
			int index = 0;
			for(EData data : EData.values()) {
				course[index][0] = data;
				index++;
			}
		}
	}
	
	public EData[][] getCourse() {return course;}
}
