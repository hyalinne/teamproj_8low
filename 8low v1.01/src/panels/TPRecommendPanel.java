package panels;

import java.awt.Color;

import javax.swing.JPanel;

import constants.TPConstants;

public class TPRecommendPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public TPRecommendPanel() {
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setLocation(0,TPConstants.MAIN_BUTTON_HEIGHT);
		this.setSize(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT);
		
	}
	
	public void init() {
		
	}
}
