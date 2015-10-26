package panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import calculator.TPCalculator;
import constants.TPConstant;
import data.TPData.EData;

public class TPMapPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	// associations
	private TPCalculator calc;
	// working variables
	private EData[] course;

	public TPMapPanel() {
		// attributes initialization
		this.setBounds(TPConstant.MP_X, TPConstant.MP_Y, TPConstant.MP_WIDTH, TPConstant.MP_HEIGHT);
		this.setLayout(null);
		// components initialization
		String[] origin = {"1", "2", "3"};
		JComboBox<String> change1 = new JComboBox<String>(origin);
		change1.setBounds(10, 60, 100, 30);
		change1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change1.setVisible(false);
			}
		});
		change1.setVisible(false);
		this.add(change1);
		JButton button1 = new JButton();
		button1.setIcon(TPConstant.ICON_EATING);
		button1.setBounds(10, 10, 44, 56);
		button1.setBackground(TPConstant.MP_COLOR);
		button1.setOpaque(false);
		button1.setBorderPainted(false);
		button1.setFocusPainted(false);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				change1.setVisible(true);
			}
		});
		this.add(button1);
	}
	
	public void init() {
		// associations initialization
		calc = TPCalculator.getInstance();
		// working variables initialization
	}
	
	public void setButton() {
		course[0].getName();
	}
	
	public void view() {
		course = calc.getCourse();
		repaint();
	}
	
	public void setCourse(EData[] course) {
		this.course = course;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(TPConstant.MAP_IMG, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
