package panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import calculator.TPCalculator;
import constants.TPConstant;
import constants.TPConstant.ECourseButton;
import constants.TPConstant.ECourseComboBoxs;
import data.TPData.EData;

public class TPMapPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	// associations
	private TPCalculator calc;
	// working variables
	private EData[][] course;
	private Vector<JComboBox<String>> changes;

	public TPMapPanel() {
		// attributes initialization
		this.setBounds(TPConstant.MP_X, TPConstant.MP_Y, TPConstant.MP_WIDTH, TPConstant.MP_HEIGHT);
		this.setLayout(null);
		// components initialization
	}
	
	public void init() {
		// associations initialization
		calc = TPCalculator.getInstance();
		// working variables initialization
		changes = new Vector<JComboBox<String>>();
	}
	
	public void makeButton() {
		for(ECourseButton temp : ECourseButton.values()) {
			JButton button = new JButton();
			button.setIcon(TPConstant.ICON_SLEEPING);
			button.setBounds(temp.getBound());
			if(course[temp.getNum()][TPConstant.SELECTED].getTheme() == TPConstant.EATING) {
				button.setIcon(TPConstant.ICON_EATING);
			} else if(course[temp.getNum()][TPConstant.SELECTED].getTheme() == TPConstant.SEEING) {
				button.setIcon(TPConstant.ICON_SEEING);
			} else if(course[temp.getNum()][TPConstant.SELECTED].getTheme() == TPConstant.SLEEPING) {
				button.setIcon(TPConstant.ICON_SLEEPING);
			}
			button.setBackground(TPConstant.MP_COLOR);
			button.setOpaque(false);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					changes.get(temp.getNum()).setVisible(true);
				}
			});
			this.add(button);
		}
	}
	
	public void makeChanges() {
		for(ECourseComboBoxs temp : ECourseComboBoxs.values()) {
			JComboBox<String> change = new JComboBox<String>(temp.getItemList());
			change.setBounds(temp.getBound());
			change.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					((JComponent)e.getSource()).setVisible(false);
				}
			});
			change.setVisible(false);
			changes.add(change);
			this.add(change);
		}
	}
	
	public void view() {
		course = calc.getCourse();
		repaint();
		this.makeChanges();
		this.makeButton();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(TPConstant.MAP_IMG, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
