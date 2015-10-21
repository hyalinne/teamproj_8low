package panels;


import java.awt.Graphics;

import javax.swing.JPanel;

import calculator.TPCalculator;
import constants.TPConstant;
import data.TPData.EData;

public class TPMapPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	// associations
	private TPCalculator calc;
	// working variables
	private EData[] course;

	public TPMapPanel() {
		this.setBackground(TPConstant.MP_COLOR);
		this.setBounds(TPConstant.MP_X, TPConstant.MP_Y, TPConstant.MP_WIDTH, TPConstant.MP_HEIGHT);
	}
	
	public void setCourse() {
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
}
