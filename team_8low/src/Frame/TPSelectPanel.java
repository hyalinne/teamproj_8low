package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import constants.TPConstant;

public class TPSelectPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	private TPCalculator calc;
	private JPanel mapPanel;
	// associations
	// working variables
	private JComboBox<String> subRegionSLT;
	private JComboBox<String> mainRegionSLT;
	private JComboBox<String> themeSLT;
	private String selectedMainRegion;
	private String selectedSubRegion;
	private String selectedTheme;
	
	public TPSelectPanel() {
		// attributes initialization
		super();
		this.setBackground(TPConstant.BACK_COLOR);
		this.setSize(TPConstant.BACK_W, TPConstant.BACK_H);
		this.setLayout(null);
		
		//components initialization
		mainRegionSLT = new JComboBox<String>(TPConstant.regionList);
		mainRegionSLT.setFont(TPConstant.SLTP_KOREAN_FONT);
		mainRegionSLT.setBackground(TPConstant.BTN_COLOR);
		mainRegionSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedMainRegion = (String) mainRegionSLT.getSelectedItem();
				if(selectedMainRegion == "서울") {
					subRegionSLT.removeAllItems();
					for(String item : TPConstant.seoulList) {
						subRegionSLT.addItem(item);
					}
				} else if(selectedMainRegion == "용인") {
					subRegionSLT.removeAllItems();
					for(String item : TPConstant.yonginList) {
						subRegionSLT.addItem(item);
					}
				}
			}
		});
		mainRegionSLT.setBounds(12, 24, 60, 30);
		this.add(mainRegionSLT);
		
		String[] tempList = {"선택"};
		subRegionSLT = new JComboBox<String>(tempList);
		subRegionSLT.setFont(TPConstant.SLTP_KOREAN_FONT);
		subRegionSLT.setBackground(TPConstant.BTN_COLOR);
		subRegionSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedSubRegion = (String)subRegionSLT.getSelectedItem();
			}
		});
		subRegionSLT.setBounds(84, 24, 60, 30);
		this.add(subRegionSLT);
		
		themeSLT = new JComboBox<String>(TPConstant.themeList);
		themeSLT.setFont(TPConstant.SLTP_KOREAN_FONT);
		themeSLT.setBackground(TPConstant.BTN_COLOR);
		themeSLT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTheme = (String)themeSLT.getSelectedItem();
			}
		});
		themeSLT.setBounds(156, 24, 60, 30);
		this.add(themeSLT);
		
		JButton runBtn = new JButton("Run");
		runBtn.setFont(TPConstant.SLTP_ENGLISH_FONT);
		runBtn.setBackground(TPConstant.BTN_COLOR);
		runBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.calculate(selectedSubRegion, selectedTheme);
			}
		});
		runBtn.setBounds(228, 25, 60, 30);
		this.add(runBtn);
		
		mapPanel = new TPMapPanel();
		add(mapPanel);
	}
	
	public void init() {
		// associations initialization
		this.calc = TPCalculator.getInstance();
		// working variables initialization
		this.selectedMainRegion = "선택";
		this.selectedSubRegion = "선택";
		this.selectedTheme = "선택";
		
	}
}
