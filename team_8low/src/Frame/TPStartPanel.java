package Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import constants.TPConstant;

public class TPStartPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	// associations
	private JFrame mainFrame;
	// working variables
	
	public TPStartPanel(JFrame mainFrame) {
		// attributes initialization
		this.setBackground(TPConstant.BACK_COLOR);
		this.mainFrame = mainFrame;
		this.setSize(TPConstant.BACK_W, TPConstant.BACK_H);
		this.addMouseListener(new MouseHandler());
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(TPConstant.INTRO_IMG, 0, 0, TPConstant.BACK_W, TPConstant.BACK_H, this);
	}
	
	private class MouseHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if((e.getX() > TPConstant.BACK_W * 0.2 && e.getX() < TPConstant.BACK_W * 0.73) 
					&& (e.getY() > TPConstant.BACK_H * 0.675 && e.getY() < TPConstant.BACK_H * 0.8)) {
				((TPFrame) mainFrame).removeMain();				
			}
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
