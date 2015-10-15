package Frame;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TPFrame extends JFrame {
	private Container contentPane;
	private JPanel startPanel;
	private JPanel sltPanel;
	private JPanel testPanel;
	
	public TPFrame() {
		super();
		this.setSize(300, 435);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		startPanel = new TPStartPanel(this);
		sltPanel = new TPSelectPanel(this);
		contentPane.add(startPanel);
		this.setVisible(true);
	}

	public void goToSelect() {
		contentPane.add(sltPanel);
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public void removeMain() {
		contentPane.remove(startPanel);
		contentPane.add(sltPanel);
		this.setVisible(false);
		this.setVisible(true);
	}

	public void mapView() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.setVisible(true);
	}
}
