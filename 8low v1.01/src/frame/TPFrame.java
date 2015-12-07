package frame;

import javax.swing.JFrame;

import constants.TPConstants;

public class TPFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private TPMainPanel mainPanel;

	public TPFrame(String name) {
		super(name);
		this.setSize(TPConstants.WIDTH, TPConstants.HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.mainPanel = new TPMainPanel();
		this.mainPanel.init();
		this.add(mainPanel);
		this.getContentPane().add(mainPanel);
	}
	
	public void init() {
		this.setVisible(true);
	}
}
