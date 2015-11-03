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
	private Map<String, Object> param; //map������!
	private DBManager db;//�������ٷ�!!!
	private String test;
	
	public TPCalculator() {
		// attributes initialization
		// components initialization
		eatingPool = new EData[20];
		seeingPool = new EData[20];
		sleepingPool = new EData[20];
		course = new EData[TPConstant.COURSE_NUM][TPConstant.CHANGE_NUM];
		param = new HashMap<String, Object>();//Map������ ����
		db = new DBManager();//��񾵲��社����
		DBManager.getInstance();//DB �����ò���!
	}
	
	public void init() {
		// associations initialization;
		// working variable initialization
		try {
			param.put("l_id", 1);//location table���� l_id�� �ִ� ģ�� �����ͼ� l_id = ? ?=1�� �Ǵ� �� �����÷�!
			test = db.select(TPConstant.sqlList.findLocation, param).getString(3);//location table���� 3��°�� �ִ� colum���� ���� �����÷��� ����
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
		// mainRegion & subRegion ���� Data�� �����ͼ� Theme �� ���� pool �� ����
		
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
