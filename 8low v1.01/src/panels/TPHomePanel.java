package panels;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import constants.TPConstants;

public class TPHomePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public TPHomePanel() {
		this.setLayout(null);
		this.setLocation(0,TPConstants.MAIN_BUTTON_HEIGHT);
		this.setSize(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT);
		this.setBackground(Color.BLACK);
	}
	
	public void init() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		ImageIcon image = new ImageIcon("rsc/HomePage.png");
		super.paint(g);
		g.drawImage(image.getImage(), 0, 0, null);
	}
}
