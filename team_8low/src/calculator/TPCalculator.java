package calculator;

import java.util.Vector;

import constants.TPConstant;
import data.TPData.EData;

public class TPCalculator {
	// attributes
	private static TPCalculator calculatorInstance;
	// components
	private Vector<EData> eatingPool;
	private Vector<EData> seeingPool;
	private Vector<EData> sleepingPool;
	private EData[][] course;
	// associations
	// working variables
	private String[] selectedItem;
	
	private TPCalculator() {
		// attributes initialization
		// components initialization
		eatingPool = new Vector<EData>();
		seeingPool = new Vector<EData>();
		sleepingPool = new Vector<EData>();
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
		for(EData data : EData.values()) {
			if(data.getTheme() == TPConstant.EATING) {
				eatingPool.add(data);
			} else if(data.getTheme() == TPConstant.SEEING) {
				seeingPool.add(data);
			} else if(data.getTheme() == TPConstant.SLEEPING) {
				sleepingPool.add(data);
			} else {
				// Error
			}
		}
	}
	
	public void courseSort() {
		if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.EATING) {
			course[0][0] = eatingPool.get(0);
			course[1][0] = seeingPool.get(0);
			course[2][0] = sleepingPool.get(0);
			course[3][0] = eatingPool.get(1);
			course[4][0] = sleepingPool.get(1);
		} else if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.SEEING) {
			
		} else if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.SLEEPING) {
			
		}
	}
	
	public EData[][] getCourse() {return course;}
}
