package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TPMapPanel extends JPanel {
	private JFrame mainFrame;
	
	public TPMapPanel(TPFrame mainFrame) {
		super();
		this.setSize(300, 435);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		
		JButton backBtn = new JButton("ก็");
		backBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((TPFrame) mainFrame).goToSelect();
			}
		});
		backBtn.setBounds(20, 20, 50, 30);
		this.add(backBtn);
		
		this.setVisible(true);
	}
}
