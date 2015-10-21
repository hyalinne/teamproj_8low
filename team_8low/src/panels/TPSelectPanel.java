package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import calculator.TPCalculator;
import constants.TPConstant;
import constants.TPConstant.EComboBoxs;

public class TPSelectPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	private JPanel mapPanel;
	private Vector<JComboBox<String>> comboBoxs;
	// associations
	private TPCalculator calc;
	// working variables
	private String[] selectedItem;
	private Vector<ActionListener> listeners;
	
	public TPSelectPanel() {
		// attributes initialization
		super();
		this.setBackground(TPConstant.BACK_COLOR);
		this.setSize(TPConstant.BACK_W, TPConstant.BACK_H);
		this.setLayout(null);
		
		//components initialization
		comboBoxs = new Vector<JComboBox<String>>();
		this.makeListener();
		int index = 0; // only use in below for statement
		for(EComboBoxs comboBox : EComboBoxs.values()) {
			JComboBox<String> temp = new JComboBox<String>(comboBox.getItemList());
			temp.setFont(TPConstant.SLTP_KOREAN_FONT);
			temp.setBackground(TPConstant.BTN_COLOR);
			temp.setBounds(comboBox.getBound());
			temp.addActionListener(listeners.get(index));
			comboBoxs.add(temp);
			this.add(temp);
			index++;
		}
		
		JButton runBtn = new JButton("Run");
		runBtn.setFont(TPConstant.SLTP_ENGLISH_FONT);
		runBtn.setBackground(TPConstant.BTN_COLOR);
		runBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calc.calculate(selectedItem);
			}
		});
		runBtn.setBounds(TPConstant.RUN_BTN_X, TPConstant.RUN_BTN_Y, TPConstant.RUN_BTN_WIDTH, TPConstant.RUN_BTN_HEIGHT);
		this.add(runBtn);
		
		mapPanel = new TPMapPanel();
		add(mapPanel);
	}

	public void init() {
		// associations initialization
		this.calc = TPCalculator.getInstance();
		// working variables initialization
		this.selectedItem = new String[3];
		for(int i = 0; i < TPConstant.COMBOBOX_NUM; i++) {
			this.selectedItem[i] = "¼±ÅÃ";
		}
	}

	private void makeListener() {
		listeners = new Vector<ActionListener>();
		listeners.add(new MainRegionListener());
		listeners.add(new SubRegionListener());
		listeners.add(new ThemeListener());
	}
	
	private class MainRegionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// receive selected main_region & put suitable sub_region to sub_region combo box
			selectedItem[TPConstant.MAIN_REGION_INDEX] = (String)comboBoxs.get(TPConstant.MAIN_REGION_INDEX).getSelectedItem();
			for(int i = 0; i < TPConstant.MAIN_REGION_NUM ; i++) {
				if(selectedItem[TPConstant.MAIN_REGION_INDEX] == TPConstant.MAIN_REGION_LIST[i]) {
					comboBoxs.get(TPConstant.SUB_REGION_INDEX).removeAllItems();
					for(String item : TPConstant.SUB_REGION_LIST[i]) {
						comboBoxs.get(TPConstant.SUB_REGION_INDEX).addItem(item);
					}
				}
			}
		}
	}
	
	private class SubRegionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedItem[TPConstant.SUB_REGION_INDEX] 
					= (String)comboBoxs.get(TPConstant.SUB_REGION_INDEX).getSelectedItem();
		}
	}
	
	private class ThemeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			selectedItem[TPConstant.THEME_INDEX] 
					= (String)comboBoxs.get(TPConstant.THEME_INDEX).getSelectedItem();
		}
	}
}
