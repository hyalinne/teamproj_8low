package Frame;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class TPMain {
	public static void main(String[] args) {
		JFrame frmlowgoToTravel = new TPFrame();
		frmlowgoToTravel.setTitle("8low-Go To Travel!");
		frmlowgoToTravel.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\uD61C\uC6A9\\Desktop\\HTML_CSS+\uC2E4\uC2B5\\images\\marker.gif"));
		frmlowgoToTravel.setFont(new Font("AmeriGarmnd BT", Font.PLAIN, 12));
		frmlowgoToTravel.setBackground(new Color(175, 238, 238));
	}
}
