package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import panels.TPMainPanel;

public class TPFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private TPMainPanel mainPanel;

	public TPFrame(String name) {
		super(name);
		setIconImage(Toolkit.getDefaultToolkit().getImage("./rsc/icon.gif"));
		setFont(new Font("Century Gothic", Font.PLAIN, 12));
		setTitle("8low - Travel!!");
		setBackground(UIManager.getColor("CheckBox.highlight"));
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mainPanel = new TPMainPanel();
		mainPanel.setBackground(new Color(57, 172, 218));
		this.getContentPane().add(mainPanel);
	}
	
	public void init() {
		
	}
}
