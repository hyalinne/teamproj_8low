package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TPSelectPanel extends JPanel {
	private JFrame mainFrame;
	private TPCalculator calc;
	private String selectedRegion;
	private String selectedTheme;
	
	public TPSelectPanel(JFrame mainFrame) {
		super();
		this.setSize(300, 400);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		this.calc = new TPCalculator();
		
		String[] regionList = {"¼­¿ï", "´ëÀü", "´ë±¸", "ºÎ»ê", "Á¦ÁÖ", "±¤ÁÖ", "ÀüÁÖ"};
		selectedRegion = "¼­¿ï";
		JComboBox regionSLT = new JComboBox(regionList);
		regionSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRegion = (String) regionSLT.getSelectedItem();
			}
		});
		regionSLT.setBounds(110, 40, 60, 30);
		this.add(regionSLT);
		
		String[] themeList = {"¸ÀÁý", "°ü±¤", "ÈÞ½Ä"};
		selectedTheme = "¸ÀÁý";
		JComboBox themeSLT = new JComboBox(themeList);
		themeSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTheme = (String) themeSLT.getSelectedItem();
			}
		});
		themeSLT.setBounds(110, 120, 60, 30);
		this.add(themeSLT);
		
		JButton runBtn = new JButton("Run");
		runBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.calculate(selectedRegion, selectedTheme);
				((TPFrame) mainFrame).goToMap();
			}
		});
		runBtn.setBounds(110, 270, 60, 30);
		this.add(runBtn);
		
		this.setVisible(true);
	}

}
