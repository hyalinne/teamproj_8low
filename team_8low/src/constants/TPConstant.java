package constants;

import java.awt.*;

public class TPConstant {
	// Common
	public final static int BACK_W = 330;
	public final static int BACK_H = 450;
	public final static Color BACK_COLOR = new Color(175, 238, 238);
	
	// Frame
	public final static String APPNAME = "8low-Go To Travel!";
	public final static Color FRAME_COLOR = new Color(175, 238, 238);
	public final static Font FRAME_FONT = new Font("AmeriGarmnd BT", Font.PLAIN, 12);
	public final static Image ICON_IMG = Toolkit.getDefaultToolkit().getImage("rsc/icon_2.gif");
	
	// StartPanel
	public final static Image INTRO_IMG = Toolkit.getDefaultToolkit().getImage("rsc/intro.jpg");
	
	// SelectPanel
	public final static Font SLTP_KOREAN_FONT = new Font("365복고언니", Font.PLAIN, 15);
	public final static Font SLTP_ENGLISH_FONT = new Font("365Shy", Font.PLAIN, 16);
	public final static Color BTN_COLOR = new Color(240, 255, 240);
	public final static String[] regionList = {"선택","서울","용인"};
	public final static String[] seoulList = {"영등포구", "광진구", "서초구"};
	public final static String[] yonginList = {"처인구", "기흥구", "수지구"};
	public final static String[] themeList = {"선택", "맛집", "관광", "휴식"};
	
	// Calc
	public final static int COURSE_NUM = 5;
}
