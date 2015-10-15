package Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class TPStartPanel extends JPanel {
	private JFrame mainFrame;
	private Image introImage;
	
	public TPStartPanel(JFrame mainFrame) {
		setBackground(new Color(175, 238, 238));
		this.mainFrame = mainFrame;
		this.setSize(300,435);
		this.setLayout(null);
		this.addMouseListener(new MouseHandler());
		introImage = Toolkit.getDefaultToolkit().getImage("rsc/intro.jpg");
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(introImage, 0, 0, 300, 400, this);
	}
	
	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getY() > 250 && e.getX() > 90 && e.getX() < 200) {
				((TPFrame) mainFrame).removeMain();				
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
