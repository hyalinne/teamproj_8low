package calculator;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import constants.TPConstant;
import data.TPData;
import databases.DBManager;

public class TPCalculator {
	// attributes
	private static TPCalculator calculatorInstance;
	// components
	private TPData[] eatingPool;
	private TPData[] seeingPool;
	private TPData[] sleepingPool;
	private TPData[][] course;
	private DBManager db;
	private Map<String, Object> param;
	// associations
	// working variables
	private String[] selectedItem;
	
	public TPCalculator() {
		// attributes initialization
		// components initialization
		eatingPool = new TPData[TPConstant.DATA_POOL_NUM];
		seeingPool = new TPData[TPConstant.DATA_POOL_NUM];
		sleepingPool = new TPData[TPConstant.DATA_POOL_NUM];
		course = new TPData[TPConstant.COURSE_NUM][TPConstant.CHANGE_NUM];
		param = new HashMap<String, Object>();
		db = DBManager.getInstance();
	}
	
	public void init() {
		// associations initialization;
		// working variable initialization
	}
	
	// Singleton
	public static TPCalculator getInstance() {
		if(calculatorInstance == null) {
			calculatorInstance = new TPCalculator();
		}
		return calculatorInstance;
	}

	// SelectPanel 에서 Run 버튼이 눌러졌을 때 동작.
	public void calculate(String[] selectedItem) {
		this.selectedItem = selectedItem;
		this.dataSort();
		this.courseSort();
	}
	
	// 조건에 맞는 Data 를 불러온다.
	public void dataSort() {
		int main_index, sub_index;
		int eating_index = 0, seeing_index = 0, sleeping_index = 0;
		for(main_index = 0; main_index < TPConstant.MAIN_REGION_LIST.length; main_index++) {
			if(selectedItem[TPConstant.MAIN_REGION_INDEX].equals(TPConstant.MAIN_REGION_LIST[main_index])) {
				break;
			}
		}
		for(sub_index = 0; sub_index < TPConstant.SUB_REGION_LIST[main_index].length; sub_index++) {
			if(selectedItem[TPConstant.SUB_REGION_INDEX].equals(TPConstant.SUB_REGION_LIST[main_index][sub_index])) {
				break;
			}
		}
		for(int i = 1; i <= 60; i++) {
			try {
				param.put("l_id", i);
				if(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getInt(TPConstant.DB_LOC_D_ID) == sub_index) {
					String theme = db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_THEME);
					
					TPData temp = new TPData();
					temp.setName(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_NAME));
					temp.setAddress(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_ADDRES));
					temp.setTel(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_TEL));
					temp.setTheme(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_THEME));
					temp.setDistance(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getFloat(TPConstant.DB_LOC_DISTANCE));
					temp.setContent(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_CONTENT));
					temp.setLink(db.select(TPConstant.ESQLList.FIND_LOCATION, param).getString(TPConstant.DB_LOC_LINK));
					
					if(theme.equals(TPConstant.EATING)) {
						eatingPool[eating_index] = temp;
						eating_index++;
					} else if(theme.equals(TPConstant.SEEING)) {
						seeingPool[seeing_index] = temp;
						seeing_index++;
					} else if(theme.equals(TPConstant.SLEEPING)) {
						sleepingPool[sleeping_index] = temp;
						sleeping_index++;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// courseSort 는 임시로 사용.
	public void courseSort() {
		if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.EATING) {
			course[0][0] = eatingPool[0];
			course[0][1] = eatingPool[1];
			course[0][2] = eatingPool[2];
			course[1][0] = seeingPool[0];
			course[1][1] = seeingPool[1];
			course[1][2] = seeingPool[2];
			course[2][0] = eatingPool[3];
			course[2][1] = eatingPool[4];
			course[2][2] = eatingPool[5];
			course[3][0] = seeingPool[3];
			course[3][1] = seeingPool[4];
			course[3][2] = seeingPool[5];
			course[4][0] = sleepingPool[0];
			course[4][1] = sleepingPool[1];
			course[4][2] = sleepingPool[2];
		} else if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.SEEING) {
			course[0][0] = eatingPool[0];
			course[0][1] = eatingPool[1];
			course[0][2] = eatingPool[2];
			course[1][0] = seeingPool[0];
			course[1][1] = seeingPool[1];
			course[1][2] = seeingPool[2];
			course[2][0] = eatingPool[3];
			course[2][1] = eatingPool[4];
			course[2][2] = eatingPool[5];
			course[3][0] = seeingPool[3];
			course[3][1] = seeingPool[4];
			course[3][2] = seeingPool[5];
			course[4][0] = sleepingPool[0];
			course[4][1] = sleepingPool[1];
			course[4][2] = sleepingPool[2];
		} else if(selectedItem[TPConstant.THEME_INDEX] == TPConstant.SLEEPING) {
			course[0][0] = eatingPool[0];
			course[0][1] = eatingPool[1];
			course[0][2] = eatingPool[2];
			course[1][0] = seeingPool[0];
			course[1][1] = seeingPool[1];
			course[1][2] = seeingPool[2];
			course[2][0] = eatingPool[3];
			course[2][1] = eatingPool[4];
			course[2][2] = eatingPool[5];
			course[3][0] = seeingPool[3];
			course[3][1] = seeingPool[4];
			course[3][2] = seeingPool[5];
			course[4][0] = sleepingPool[0];
			course[4][1] = sleepingPool[1];
			course[4][2] = sleepingPool[2];
		} else {
			// Testing 
		}
	}
	
	public TPData[][] getCourse() {return course;}
}
