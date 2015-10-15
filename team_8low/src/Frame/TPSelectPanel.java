package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;

public class TPSelectPanel extends JPanel {
	private JFrame mainFrame;
	private TPCalculator calc;
	private String selectedRegion;
	private String selectedTheme;
	
	public TPSelectPanel(JFrame mainFrame) {
		super();
		setBackground(new Color(175, 238, 238));
		this.setSize(300, 435);
		this.setLayout(null);
		this.mainFrame = mainFrame;
		this.calc = new TPCalculator();
		
		String[] region1List = {"용인",""};
		selectedRegion = "서울";
		JComboBox region1SLT = new JComboBox(region1List);
		region1SLT.setFont(new Font("365복고언니", Font.PLAIN, 15));
		region1SLT.setBackground(new Color(240, 255, 240));
		region1SLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRegion = (String) region1SLT.getSelectedItem();
			}
		});
		region1SLT.setBounds(12, 24, 60, 30);
		this.add(region1SLT);
		
		String[] region2List = {"처인구", "기흥구", "수지구"};
		selectedRegion = "서울";
		JComboBox region2SLT = new JComboBox(region2List);
		region2SLT.setFont(new Font("365복고언니", Font.PLAIN, 15));
		region2SLT.setBackground(new Color(240, 255, 240));
		region2SLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedRegion = (String) region2SLT.getSelectedItem();
			}
		});
		region2SLT.setBounds(84, 24, 60, 30);
		this.add(region2SLT);
		
		String[] themeList = {"맛집", "관광", "휴식"};
		selectedTheme = "맛집";
		JComboBox themeSLT = new JComboBox(themeList);
		themeSLT.setFont(new Font("365복고언니", Font.PLAIN, 15));
		themeSLT.setBackground(new Color(240, 255, 240));
		themeSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTheme = (String) themeSLT.getSelectedItem();
			}
		});
		themeSLT.setBounds(156, 24, 60, 30);
		this.add(themeSLT);
		
		JButton runBtn = new JButton("Run");
		runBtn.setForeground(new Color(0, 0, 0));
		runBtn.setFont(new Font("365Shy", Font.PLAIN, 16));
		runBtn.setBackground(new Color(240, 255, 240));
		runBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.calculate(selectedRegion, selectedTheme);
			
			}
		});
		runBtn.setBounds(228, 25, 60, 30);
		this.add(runBtn);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 64, 276, 326);
		add(panel);
	}
}
