package constants;

import java.awt.*;

import javax.swing.ImageIcon;

public class TPConstant {
	// Common
	public final static int BACK_W = 330;
	public final static int BACK_H = 470;
	public final static Color BACK_COLOR = new Color(255,230,181);
	public final static Color BTN_COLOR = new Color(240, 255, 240);
	
	public final static String EATING = "¸ÀÁý";
	public final static String SEEING = "°ü±¤";
	public final static String SLEEPING = "ÈÞ½Ä";
	
	// Frame
	public final static String APPNAME = "8low-Go To Travel!";
	public final static Color FRAME_COLOR = new Color(255,230,181);
	public final static Font FRAME_FONT = new Font("AmeriGarmnd BT", Font.BOLD, 12);
	public final static Image ICON_IMG = Toolkit.getDefaultToolkit().getImage("rsc/icon.gif");
	
	// StartPanel
	public final static Image INTRO_IMG = Toolkit.getDefaultToolkit().getImage("rsc/intro.png");
	
	// SelectPanel
	
	// basic setting
	public final static Font SLTP_KOREAN_FONT = new Font("1ÈÆ±×¸²µ¿È­ R", Font.PLAIN, 14);
	public final static Font SLTP_ENGLISH_FONT = new Font("Arial", Font.BOLD, 12);
	
	// string setting
	public final static String[] MAIN_REGION_LIST = {"¼±ÅÃ","¿ëÀÎ"};
	public final static String[][] SUB_REGION_LIST = {{"¼±ÅÃ"},
			{"¼±ÅÃ", "Ã³ÀÎ±¸", "±âÈï±¸", "¼öÁö±¸"}};
	public final static String[] THEME_LIST = {"¼±ÅÃ", "¸ÀÁý", "°ü±¤", "ÈÞ½Ä"};
	
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
	public final static String MP_WARN_MSG = "µ¥ÀÌÅÍ ºÎÁ· ¤Ð¤Ð";
	public final static int MP_WARN_X = 70;
	public final static int MP_WARN_Y = 120;
	public final static int MP_WARN_WIDTH = 200;
	public final static int MP_WARN_HEIGHT = 40;
	public final static Font MP_WARN_FONT = new Font("1ÈÆ±×¸²µ¿È­ R", Font.BOLD, 25);
	
	public final static Font MP_CHANGE_FONT = new Font("¸¼Àº °íµñ", Font.PLAIN, 13);
	public final static Font MP_TEXT_FONT = new Font("¸¼Àº °íµñ", Font.PLAIN, 9);
	
	public enum EMapExplainState {on, off;}
	public enum EMapChangeState {on, off;}
	
	public final static Color MP_COLOR = Color.WHITE;
	public final static int MP_X = 12;
	public final static int MP_Y = 64;
	public final static int MP_WIDTH = 276;
	public final static int MP_HEIGHT = 326;
	
	public final static Image MAP_IMG = Toolkit.getDefaultToolkit().getImage("rsc/map2.jpg");
	
	public final static ImageIcon ICON_EATING = new ImageIcon("rsc/icon_eating.png");
	public final static ImageIcon ICON_SLEEPING = new ImageIcon("rsc/icon_sleeping.png");
	public final static ImageIcon ICON_SEEING = new ImageIcon("rsc/icon_seeing.png");
	
	public final static int SELECTED = 0;
	
	public enum ECourseButtons {
		first(0, new Rectangle(10, 10, 44, 56)),
		second(1, new Rectangle(120, 60, 44, 56)),
		third(2, new Rectangle(215, 120, 44, 56)),
		fourth(3, new Rectangle(120, 190, 44, 56)),
		fifth(4, new Rectangle(10, 250, 44, 56));
		
		private int num;
		private Rectangle bound;
		public int getNum() {return num;}
		public Rectangle getBound() {return bound;}
	
		private ECourseButtons(int num, Rectangle bound) {
			this.num = num;
			this.bound = bound;
		}
	}
	
	public enum ECourseComboBoxs {
		first(0, new Rectangle(10, 60, 100, 30)),
		second(1, new Rectangle(100, 110, 100, 30)),
		third(2, new Rectangle(175, 170, 100, 30)),
		fourth(3, new Rectangle(100, 240, 100, 30)),
		fifth(4, new Rectangle(10, 290, 100, 30));
		
		private int num;
		private String[] itemList;	
		private Rectangle bound;
		public int getNum() {return num;}
		public String[] getItemList() {return itemList;}
		public Rectangle getBound() {return bound;}
		
		public void setItemList(String[] itemList) {this.itemList = itemList;}
	
		private ECourseComboBoxs(int num, Rectangle bound) {
			this.num = num;
			this.bound = bound;
		}
	}
	
	public enum ECourseTexts {
		first(0, 10, 60),
		second(1, 100, 110),
		third(2, 115, 120),
		fourth(3, 100, 130),
		fifth(4, 10, 190);
		
		private int num, x, y;
		public int getNum() {return num;}
		public int getX() {return x;}
		public int getY() {return y;}
	
		private ECourseTexts(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	// Calculator
	public final static int COURSE_NUM = 5;
	public final static int CHANGE_NUM = 3;
	public final static int DATA_POOL_NUM = 20;
	
	public final static int DB_LOC_D_ID = 2;
	public final static int DB_LOC_NAME = 3;
	public final static int DB_LOC_ADDRES = 4;
	public final static int DB_LOC_TEL = 5;
	public final static int DB_LOC_THEME = 6;
	public final static int DB_LOC_DISTANCE = 7;
	public final static int DB_LOC_CONTENT = 8;
	public final static int DB_LOC_LINK = 9;
	
	//DBManager
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost:3306/team_8low";
	public final static String USERNAME = "root";
	public final static String PASSWORD = "team8low";
	
	public static enum ESQLList { FIND_CITY, FIND_ALL_CITY, FIND_DISTRICT, FIND_ALL_DISTRICT, FIND_LOCATION, FIND_ALL_LOCATION, ADD_CITY, ADD_DISTRICT, ADD_LOCATION, DELETE_CITY, DELETE_DISTRICT, DELETE_LOCATION};
	
	public final static String FIND_CITY = "SELECT c_id, c_name FROM city WHERE c_id=?";
	public final static String FIND_ALL_CITY = "SELECT c_id, c_name FROM city ORDER BY c_id DESC";
	public final static String FIND_DISTRICT = "SELECT c_id, d_id, d_name FROM district WHERE d_id=?";
	public final static String FIND_ALL_DISTRICT = "SELECT c_id, d_id, d_name FROM district ORDER BY d_id DESC";
	public final static String FIND_LOCATION = "SELECT l_id, d_id, l_name, l_adress, l_tel, l_theme, l_distance, l_content, l_link FROM location WHERE l_id=?";
	public final static String FIND_ALL_LOCATION = "SELECT l_id, d_id, l_name, l_adress, l_tel, l_theme, l_distance, l_content, l_link FROM location ORDER BY l_id DESC";
	
	public final static String ADD_CITY = "INSERT INTO city (c_name) VALUES (?)";
	public final static String ADD_DISTRICT = "INSERT INTO district (c_id, d_name) VALUES (?, ?)";
	public final static String ADD_LOCATION = "INSERT INTO location (d_id, l_name, l_adress, l_tel, l_theme, l_distance, l_content, l_link) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public final static String DELETE_CITY = "DELETE FROM city WHERE c_id=?";
	public final static String DELETE_DISTRICT = "DELETE FROM district WHERE d_id=?";
	public final static String DELETE_LOCATION = "DELETE FROM location WHERE l_id=?";
}
