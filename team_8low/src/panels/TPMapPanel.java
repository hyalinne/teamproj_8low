package panels;


import java.awt.Graphics;

import javax.swing.JPanel;

import constants.TPConstant;

public class TPMapPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;

	public TPMapPanel() {
		this.setBackground(TPConstant.MP_COLOR);
		this.setBounds(TPConstant.MP_X, TPConstant.MP_Y, TPConstant.MP_WIDTH, TPConstant.MP_HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
}
