package constants;

import java.awt.*;

import javax.swing.ImageIcon;

public class TPConstant {
	// Common
	public final static int BACK_W = 330;
	public final static int BACK_H = 470;
	public final static Color BACK_COLOR = new Color(255,230,181);
	
	public final static String EATING = "����";
	public final static String SEEING = "����";
	public final static String SLEEPING = "�޽�";
	
	// Frame
	public final static String APPNAME = "8low-Go To Travel!";
	public final static Color FRAME_COLOR = new Color(255,230,181);
	public final static Font FRAME_FONT = new Font("AmeriGarmnd BT", Font.PLAIN, 12);
	public final static Image ICON_IMG = Toolkit.getDefaultToolkit().getImage("rsc/icon.gif");
	
	// StartPanel
	public final static Image INTRO_IMG = Toolkit.getDefaultToolkit().getImage("rsc/intro.png");
	
	// SelectPanel
	
	// basic setting
	public final static Font SLTP_KOREAN_FONT = new Font("365�������", Font.PLAIN, 12);
	public final static Font SLTP_ENGLISH_FONT = new Font("365Shy", Font.PLAIN, 13);
	public final static Color BTN_COLOR = new Color(240, 255, 240);
	
	// string setting
	public final static int MAIN_REGION_NUM = 2;
	public final static String[] MAIN_REGION_LIST = {"����","����"};
	public final static String[][] SUB_REGION_LIST = {{"����"},
			{"����", "ó�α�", "���ﱸ", "������"}};
	public final static String[] THEME_LIST = {"����", "����", "����", "�޽�"};
	
	// combo box setting
	public final static int MAIN_REGION_INDEX = 0;
	public final static int SUB_REGION_INDEX = 1;
	public final static int THEME_INDEX = 2;
	public final static int COMBOBOX_NUM = 3;
	public enum ESelectComboBoxs {
		mainRegion(MAIN_REGION_LIST, new Rectangle(12, 24, 60, 30)),
		subRegion(SUB_REGION_LIST[0], new Rectangle(84, 24, 60, 30)),
		theme(THEME_LIST, new Rectangle(156, 24, 60, 30));
		
		private String[] itemList;	
		private Rectangle bound;
		public String[] getItemList() {return itemList;}
		public void setItemList(String[] itemList) {this.itemList = itemList;}
		public Rectangle getBound() {return bound;}
	
		private ESelectComboBoxs(String[] itemList, Rectangle bound) {
			this.itemList = itemList;
			this.bound = bound;
		}
	}
	
	//run button bounds
	public final static int RUN_BTN_X = 228;
	public final static int RUN_BTN_Y = 25;
	public final static int RUN_BTN_WIDTH = 60;
	public final static int RUN_BTN_HEIGHT = 30;
	
	// MapPanel
	public enum EMapExplainState {on, off;}
	public enum EMapChangeState {on, off;}
	
	public final static Color MP_COLOR = Color.WHITE;
	public final static int MP_X = 12;
	public final static int MP_Y = 64;
	public final static int MP_WIDTH = 276;
	public final static int MP_HEIGHT = 326;
	
	public final static Image MAP_IMG = Toolkit.getDefaultToolkit().getImage("rsc/map.png");
	
	public final static ImageIcon ICON_EATING = new ImageIcon("rsc/icon_eating.png");
	public final static ImageIcon ICON_SLEEPING = new ImageIcon("rsc/icon_sleeping.png");
	public final static ImageIcon ICON_SEEING = new ImageIcon("rsc/icon_seeing.png");
	
	public final static int SELECTED = 0;
	
	public enum ECourseButtons {
		first(0, new Rectangle(10, 10, 44, 56)),
		second(1, new Rectangle(105, 70, 44, 56)),
		third(2, new Rectangle(195, 120, 44, 56)),
		fourth(3, new Rectangle(120, 180, 44, 56)),
		fifth(4, new Rectangle(30, 230, 44, 56));
		
		private int num;
		private Rectangle bound;
		public int getNum() {return num;}
		public Rectangle getBound() {return bound;}
	
		private ECourseButtons(int num, Rectangle bound) {
			this.num = num;
			this.bound = bound;
		}
	}
	
	public final static String[] BASE_SELECT = {"����", "����", "����"};
	public enum ECourseComboBoxs {
		first(new Rectangle(10, 60, 100, 30)),
		second(new Rectangle(90, 120, 100, 30)),
		third(new Rectangle(175, 170, 100, 30)),
		fourth(new Rectangle(100, 230, 100, 30)),
		fifth(new Rectangle(25, 280, 100, 30));
		
		private String[] itemList;	
		private Rectangle bound;
		public String[] getItemList() {return itemList;}
		public void setItemList(String[] itemList) {this.itemList = itemList;}
		public Rectangle getBound() {return bound;}
	
		private ECourseComboBoxs(Rectangle bound) {
			this.itemList = BASE_SELECT;
			this.bound = bound;
		}
	}
	
	public enum ECourseTexts {
		first(new Rectangle(10, 60, 100, 70)),
		second(new Rectangle(90, 120, 100, 70)),
		third(new Rectangle(95, 110, 100, 70)),
		fourth(new Rectangle(100, 230, 100, 70)),
		fifth(new Rectangle(25, 170, 100, 70));
		
		private Rectangle bound;
		public Rectangle getBound() {return bound;}
	
		private ECourseTexts(Rectangle bound) {
			this.bound = bound;
		}
	}
	
	// Calculator
	public final static int COURSE_NUM = 5;
	public final static int CHANGE_NUM = 5;
	
	//DBManager
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost:3306/team_8low";
	public final static String USERNAME = "root";
	public final static String PASSWORD = "gks123";
	
	public static enum sqlList{findCity, findAllCity, findDistrict, findAllDistrict, findLocation, findAllLocation, addCity, addDistrict, addLocation, deleteCity, deleteDistrict, deleteLocation};
	
	public final static String findCity = "SELECT c_id, c_name FROM city WHERE c_id=?";
	public final static String findAllCity = "SELECT c_id, c_name FROM city ORDER BY c_id DESC";
	public final static String findDistrict = "SELECT c_id, d_id, d_name FROM district WHERE d_id=?";
	public final static String findAllDistrict = "SELECT c_id, d_id, d_name FROM district ORDER BY d_id DESC";
	public final static String findLocation = "SELECT l_id, d_id, l_name, l_adress, l_tel, l_theme, l_distance, l_content, l_link FROM location WHERE l_id=?";
	public final static String findAllLocation = "SELECT l_id, d_id, l_name, l_adress, l_tel, l_theme, l_distance, l_content, l_link FROM location ORDER BY l_id DESC";
	
	public final static String addCity = "INSERT INTO city (c_name) VALUES (?)";
	public final static String addDistrict = "INSERT INTO district (c_id, d_name) VALUES (?, ?)";
	public final static String addLocation = "INSERT INTO location (d_id, l_name, l_adress, l_tel, l_theme, l_distance, l_content, l_link) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public final static String deleteCity = "DELETE FROM city WHERE c_id=?";
	public final static String deleteDistrict = "DELETE FROM district WHERE d_id=?";
	public final static String deleteLocation = "DELETE FROM location WHERE l_id=?";
}
