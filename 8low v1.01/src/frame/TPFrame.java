package frame;

import javax.swing.JFrame;

import panels.TPMainPanel;

public class TPFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private TPMainPanel mainPanel;

	public TPFrame(String name) {
		super(name);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mainPanel = new TPMainPanel();
		this.getContentPane().add(mainPanel);
	}
	
	public void init() {
		
	}
}
