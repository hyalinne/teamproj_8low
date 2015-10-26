package frame;

import java.awt.Container;

import javax.swing.JFrame;

import constants.TPConstant;
import panels.TPSelectPanel;
import panels.TPStartPanel;

public class TPFrame extends JFrame {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	private Container contentPane;
	private TPStartPanel startPanel;
	private TPSelectPanel sltPanel;
	// associations
	// working variable
	
	public TPFrame() {
		// attributes initialization
		this.setSize(TPConstant.BACK_W, TPConstant.BACK_H);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(TPConstant.APPNAME);
		this.setIconImage(TPConstant.ICON_IMG);
		this.setFont(TPConstant.FRAME_FONT);
		this.setBackground(TPConstant.FRAME_COLOR);
		
		// components initialization
		contentPane = this.getContentPane();
		startPanel = new TPStartPanel(this);
		sltPanel = new TPSelectPanel();
		sltPanel.init();
		contentPane.add(startPanel);
		this.setVisible(true);
	}
	
	public void removeMain() {
		contentPane.remove(startPanel);
		contentPane.add(sltPanel);
		this.setVisible(false);
		this.setVisible(true);
	}
}
