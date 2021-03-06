package panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calculator.TPCalculator;
import constants.TPConstant;
import constants.TPConstant.ECourseButtons;
import constants.TPConstant.ECourseComboBoxs;
import constants.TPConstant.ECourseTexts;
import constants.TPConstant.EMapChangeState;
import constants.TPConstant.EMapExplainState;
import data.TPData;

public class TPMapPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// components
	private JComboBox<String>[] changes;
	private TextArea[] explains;
	private JLabel warning;
	// associations
	private TPCalculator calc;
	// working variables
	private TPData[][] course;
	private boolean run;
	private EMapExplainState eEState;
	private EMapChangeState eCState;
	
	public TPMapPanel() {
		// attributes initialization
		this.setBounds(TPConstant.MP_X, TPConstant.MP_Y, TPConstant.MP_WIDTH, TPConstant.MP_HEIGHT);
		this.setLayout(null);
		this.setBackground(TPConstant.MP_COLOR);
		// components initialization
		changes = new JComboBox[5];
		explains = new TextArea[5];
		warning = new JLabel(TPConstant.MP_WARN_MSG);
		warning.setBounds(TPConstant.MP_WARN_X, TPConstant.MP_WARN_Y, TPConstant.MP_WARN_WIDTH, TPConstant.MP_WARN_HEIGHT);
		warning.setFont(TPConstant.MP_WARN_FONT);
		warning.setVisible(false);
		this.add(warning);
	}
	
	public void init() {
		// associations initialization
		calc = TPCalculator.getInstance();
		run = false;
		eEState = EMapExplainState.off;
		eCState = EMapChangeState.off;
	}
	
	public void makeButtons() {
		for(ECourseButtons temp : ECourseButtons.values()) {
			JButton button = new JButton();
			button.setIcon(TPConstant.ICON_SLEEPING);
			button.setBounds(temp.getBound());
			if(course[temp.getNum()][TPConstant.SELECTED].getTheme().equals(TPConstant.EATING)) {
				button.setIcon(TPConstant.ICON_EATING);
			} else if(course[temp.getNum()][TPConstant.SELECTED].getTheme().equals(TPConstant.SEEING)) {
				button.setIcon(TPConstant.ICON_SEEING);
			} else if(course[temp.getNum()][TPConstant.SELECTED].getTheme().equals(TPConstant.SLEEPING)) {
				button.setIcon(TPConstant.ICON_SLEEPING);
			}
			button.setBackground(TPConstant.MP_COLOR);
			button.setOpaque(false);
			button.setBorderPainted(false);
			button.setFocusPainted(false);
			button.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if(eEState == EMapExplainState.on) {
						explains[temp.getNum()].setVisible(false);
						eEState = EMapExplainState.off;
					}
				}
				@Override
				public void mousePressed(MouseEvent e) {
					if(eEState == EMapExplainState.off) {
						explains[temp.getNum()].setVisible(true);
						eEState = EMapExplainState.on;
					}
				}
				@Override 
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(e.getClickCount() == 2) {
						if(eCState == EMapChangeState.off) {
							changes[temp.getNum()].setVisible(true);
							eCState = EMapChangeState.on;
						}
					} else if(e.getClickCount() == 1) {
						if(eCState == EMapChangeState.on) {
							changes[temp.getNum()].setVisible(false);
							eCState = EMapChangeState.off;
						}
					}
				}
			});
			this.add(button);
		}
	}
	
	public void makeChanges() {
		for(ECourseComboBoxs temp : ECourseComboBoxs.values()) {
			String[] names = new String[TPConstant.CHANGE_NUM];
			for(int i = 0; i < TPConstant.CHANGE_NUM; i++) {
				names[i] = course[temp.getNum()][i].getName();
			}
			changes[temp.getNum()] = new JComboBox<String>(names);
			changes[temp.getNum()].setBounds(temp.getBound());
			changes[temp.getNum()].setFont(TPConstant.MP_CHANGE_FONT);
			changes[temp.getNum()].setBackground(TPConstant.BTN_COLOR);
			changes[temp.getNum()].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					((JComponent)e.getSource()).setVisible(false);
					change(temp.getNum(), changes[temp.getNum()].getSelectedIndex());
				}
			});
			changes[temp.getNum()].setVisible(false);
			this.add(changes[temp.getNum()]);
		}
	}
	
	public void makeTexts() {
		for(ECourseTexts temp : ECourseTexts.values()) {
			explains[temp.getNum()] = new TextArea();
			explains[temp.getNum()].setBounds(temp.getX(), temp.getY(), 100, 60);
			explains[temp.getNum()].setText("번호 : " + course[temp.getNum()][TPConstant.SELECTED].getTel() + "\n" +
					"주소 : " + course[temp.getNum()][TPConstant.SELECTED].getAddress() + "\n" +
					"사이트 : " + course[temp.getNum()][TPConstant.SELECTED].getLink() + "\n" +
					"소개 : " + course[temp.getNum()][TPConstant.SELECTED].getContent());
			explains[temp.getNum()].setFont(TPConstant.MP_TEXT_FONT);
			explains[temp.getNum()].setBackground(TPConstant.MP_COLOR);
			explains[temp.getNum()].setVisible(false);
			this.add(explains[temp.getNum()]);
		}
	}
	
	public void view() {
		run = true;
		course = calc.getCourse();
		if(!this.check()) {
			this.removeAll();
			this.add(warning);
			this.warning.setVisible(true);
			run = false;
			repaint();
			return;
		} else {
			this.warning.setVisible(false);
		}
		this.removeAll();
		this.makeChanges();
		this.makeTexts();
		this.makeButtons();
		repaint();
	}
	
	private boolean check() {
		for(int i = 0; i < TPConstant.COURSE_NUM; i++) {
			for(int j = 0; j < TPConstant.CHANGE_NUM; j++) {
				if(course[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}

	public void change(int change_index, int select_index) {
		if(change_index < TPConstant.COURSE_NUM && select_index < TPConstant.CHANGE_NUM) {
			TPData temp = course[change_index][TPConstant.SELECTED];
			course[change_index][TPConstant.SELECTED] = course[change_index][select_index];
			course[change_index][select_index] = temp;
			this.removeAll();
			this.makeChanges();
			this.makeTexts();
			this.makeButtons();
			repaint();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(run) {
			g.drawImage(TPConstant.MAP_IMG, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}
	
}
