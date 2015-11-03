package calculator;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import constants.TPConstant;
import data.TPData.EData;
import databases.DBManager;

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
	private Map<String, Object> param; //map쓸꺼양!
	private DBManager db;//선언해줄랭!!!
	private String test;
	
	public TPCalculator() {
		// attributes initialization
		// components initialization
		eatingPool = new EData[20];
		seeingPool = new EData[20];
		sleepingPool = new EData[20];
		course = new EData[TPConstant.COURSE_NUM][TPConstant.CHANGE_NUM];
		param = new HashMap<String, Object>();//Map쓸려고 만듬
		db = new DBManager();//디비쓸꺼양ㅎㅎㅎ
		DBManager.getInstance();//DB 가져올꺼양!
	}
	
	public void init() {
		// associations initialization;
		// working variable initialization
		try {
			param.put("l_id", 1);//location table에서 l_id에 있는 친구 가져와서 l_id = ? ?=1이 되는 걸 가져올랭!
			test = db.select(TPConstant.sqlList.findLocation, param).getString(3);//location table에서 3번째에 있는 colum에서 값을 가져올래용 ㅎㅎ
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
		System.out.println("check " + test);
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
