package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TPSelectPanel extends JPanel {
	private JFrame mainFrame;
	private TPCalculator calc;
	private String selectedRegion;
	private String selectedTheme;
	
	public TPSelectPanel(JFrame mainFrame) {
		super();
		this.setSize(300, 435);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		this.calc = TPCalculator.getInstance();
		
		JLabel regionLabel = new JLabel("����");
		regionLabel.setBounds(125, 50, 30, 30);
		this.add(regionLabel);
		String[] regionList = {"����", "����", "�뱸", "�λ�", "����", "����", "����"};
		selectedRegion = "����";
		JComboBox regionSLT = new JComboBox(regionList);
		regionSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRegion = (String) regionSLT.getSelectedItem();
			}
		});
		regionSLT.setBounds(100, 80, 80, 30);
		this.add(regionSLT);
		
		JLabel themeLabel = new JLabel("�׸�");
		themeLabel.setBounds(125, 150, 30, 30);
		this.add(themeLabel);
		String[] themeList = {"����", "����", "�޽�"};
		selectedTheme = "����";
		JComboBox themeSLT = new JComboBox(themeList);
		themeSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTheme = (String) themeSLT.getSelectedItem();
			}
		});
		themeSLT.setBounds(100, 180, 80, 30);
		this.add(themeSLT);
		
		JButton runBtn = new JButton("Run");
		runBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.calculate(selectedRegion, selectedTheme);
				((TPFrame) mainFrame).goToMap();
			}
		});
		runBtn.setBounds(110, 310, 60, 30);
		this.add(runBtn);
		
		this.setVisible(true);
	}

}
