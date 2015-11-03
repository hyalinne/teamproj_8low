package panels;

import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import calculator.TPCalculator;
import constants.TPConstant;
import constants.TPConstant.ECourseButtons;
import constants.TPConstant.ECourseComboBoxs;
import constants.TPConstant.ECourseTexts;
import constants.TPConstant.EMapChangeState;
import constants.TPConstant.EMapExplainState;
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
	private TextField[] explains;
	private EMapExplainState eEState;
	private EMapChangeState eCState;
	
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
		explains = new TextField[5];
		eEState = EMapExplainState.off;
		eCState = EMapChangeState.off;
	}
	
	public void makeButtons() {
		for(ECourseButtons temp : ECourseButtons.values()) {
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
							changes.get(temp.getNum()).setVisible(true);
							eCState = EMapChangeState.on;
						}
					} else {
						if(eCState == EMapChangeState.on) {
							changes.get(temp.getNum()).setVisible(false);
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
	
	public void makeTexts() {
		int index = 0;
		for(ECourseTexts temp : ECourseTexts.values()) {
			explains[index] = new TextField();
			explains[index].setBounds(temp.getBound());
			explains[index].setBackground(TPConstant.MP_COLOR);
			explains[index].setVisible(false);
			this.add(explains[index]);
			index++;
		}
	}
	
	public void view() {
		course = calc.getCourse();
		repaint();
		this.makeChanges();
		this.makeTexts();
		this.makeButtons();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(TPConstant.MAP_IMG, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
