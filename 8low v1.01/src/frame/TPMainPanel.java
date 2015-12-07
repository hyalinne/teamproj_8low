package frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import constants.TPConstants;
import panels.TPCoursePanel;
import panels.TPHomePanel;
import panels.TPRecommendPanel;
import panels.TPTimePanel;

public class TPMainPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private ActionHandler actionHandler;
	
	private JPanel currentPanel;
	private TPHomePanel homePanel;
	private TPCoursePanel coursePanel;
	private TPTimePanel timePanel;
	private TPRecommendPanel recommendPanel;
	
	private JRadioButton homeBtn;
	private JRadioButton courseBtn;
	private JRadioButton timeBtn;
	private JRadioButton recommendBtn;

	public TPMainPanel() {
		super();
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.setSize(TPConstants.WIDTH, TPConstants.HEIGHT);
		
		this.actionHandler = new ActionHandler();
		
		this.homePanel = new TPHomePanel();
		this.homePanel.init();
		this.add(homePanel);
		
		this.coursePanel = new TPCoursePanel();
		this.coursePanel.init();
		this.add(coursePanel);
		
		this.timePanel = new TPTimePanel();
		this.timePanel.init();
		this.add(timePanel);
		
		this.recommendPanel = new TPRecommendPanel();
		this.recommendPanel.init();
		this.add(recommendPanel);
		
	}
	
	public void init() {
		ButtonGroup buttonGroup = new ButtonGroup();
		
		homeBtn = new JRadioButton();
		homeBtn.setIcon(new ImageIcon("rsc/Homebutton.png"));
		homeBtn.setSelectedIcon(new ImageIcon("rsc/HomebuttonSlt.png"));
		homeBtn.setBounds(0, 0, TPConstants.MAIN_BUTTON_WIDTH, TPConstants.MAIN_BUTTON_HEIGHT);
		homeBtn.addActionListener(this.actionHandler);
		this.add(homeBtn);
		buttonGroup.add(homeBtn);
		
		courseBtn = new JRadioButton();
		courseBtn.setIcon(new ImageIcon("rsc/Rootbutton.png"));
		courseBtn.setSelectedIcon(new ImageIcon("rsc/RootbuttonSlt.png"));
		courseBtn.setBounds(TPConstants.MAIN_BUTTON_WIDTH * 1, 0, TPConstants.MAIN_BUTTON_WIDTH, TPConstants.MAIN_BUTTON_HEIGHT);
		courseBtn.addActionListener(this.actionHandler);
		this.add(courseBtn);
		buttonGroup.add(courseBtn);
		
		timeBtn = new JRadioButton();
		timeBtn.setIcon(new ImageIcon("rsc/Timebutton.png"));
		timeBtn.setSelectedIcon(new ImageIcon("rsc/TimebuttonSlt.png"));
		timeBtn.setBounds(TPConstants.MAIN_BUTTON_WIDTH * 2, 0, TPConstants.MAIN_BUTTON_WIDTH, TPConstants.MAIN_BUTTON_HEIGHT);
		timeBtn.addActionListener(this.actionHandler);
		this.add(timeBtn);
		buttonGroup.add(timeBtn);
		
		recommendBtn = new JRadioButton();
		recommendBtn.setIcon(new ImageIcon("rsc/Recommendbutton.png"));
		recommendBtn.setSelectedIcon(new ImageIcon("rsc/RecommendbuttonSlt.png"));
		recommendBtn.setBounds(TPConstants.MAIN_BUTTON_WIDTH * 3, 0, TPConstants.MAIN_BUTTON_WIDTH, TPConstants.MAIN_BUTTON_HEIGHT);
		recommendBtn.addActionListener(this.actionHandler);
		this.add(recommendBtn);
		buttonGroup.add(recommendBtn);
		
		this.homeBtn.doClick();
		this.currentPanel = this.homePanel;
		this.currentPanel.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.homePanel.setVisible(false);
		this.coursePanel.setVisible(false);
		this.timePanel.setVisible(false);
		this.recommendPanel.setVisible(false);
		this.currentPanel.setVisible(true);
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(homeBtn)) {
				currentPanel = homePanel;
			} else if(e.getSource().equals(courseBtn)) {
				currentPanel = coursePanel;
			} else if(e.getSource().equals(timeBtn)) {
				currentPanel = timePanel;
			} else if(e.getSource().equals(recommendBtn)) {
				currentPanel = recommendPanel;
			}
			repaint();
		}
		
	}
}
