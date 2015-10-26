package panels;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import constants.TPConstant;
import frame.TPFrame;

public class TPStartPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	// associations
	private TPFrame mainFrame;
	// working variables
	
	public TPStartPanel(TPFrame mainFrame) {
		// attributes initialization
		this.setBackground(TPConstant.BACK_COLOR);
		this.mainFrame = mainFrame;
		this.setSize(TPConstant.BACK_W, TPConstant.BACK_H);
		this.addMouseListener(new MouseHandler());
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(TPConstant.INTRO_IMG, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	private class MouseHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			mainFrame.removeMain();
		}
		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) { }
	}
}
