package panels;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

import data.TPData;

public class TPCoursePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private enum EState {idle, remove, change1, change2};
	private EState currentState;
	
	private MouseListener mouseListener;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton changeBtn;
	private JButton undoBtn;
	private JButton redoBtn;
	private JButton saveBtn;
	private JButton loadBtn;
	
	private TPData firstArea;
	private TPData lastArea;

	public TPCoursePanel() {
		this.currentState = EState.idle;
		this.setLayout(null);
		this.setSize(700, 500);
		this.mouseListener = new MouseHandler();
		this.addMouseListener(mouseListener);
	}
	
	public void init() {
		this.makeButton();
		this.makeCourses();
		repaint();
	}
	
	private void makeButton() {
		this.addBtn = new JButton("+");
		this.addBtn.setBounds(600, 20, 50, 30);
		this.addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addArea(addData());
				repaint();
			}
		});
		this.add(addBtn);
		
		this.removeBtn = new JButton("-");
		this.removeBtn.setBounds(600, 60, 50, 30);
		this.removeBtn.addMouseListener(mouseListener);
		this.add(removeBtn);
		
		this.changeBtn = new JButton("C");
		this.changeBtn.setBounds(600, 100, 50, 30);
		this.changeBtn.addMouseListener(mouseListener);
		this.add(changeBtn);
		
		this.undoBtn = new JButton("Undo");
		this.undoBtn.setBounds(590, 200, 70, 30);
		this.undoBtn.addMouseListener(mouseListener);
		this.add(undoBtn);
		
		this.redoBtn = new JButton("Redo");
		this.redoBtn.setBounds(590, 240, 70, 30);
		this.redoBtn.addMouseListener(mouseListener);
		this.add(redoBtn);
		
		this.saveBtn = new JButton("Save");
		this.saveBtn.setBounds(590, 340, 70, 30);
		this.saveBtn.addMouseListener(mouseListener);
		this.add(saveBtn);
		
		this.loadBtn = new JButton("Load");
		this.loadBtn.setBounds(590, 380, 70, 30);
		this.loadBtn.addMouseListener(mouseListener);
		this.add(loadBtn);
	}
	
	private TPData addData() {
		TPData tempData = null;
		JDialog temp = new JDialog();
		temp.setLayout(null);
		temp.setTitle("¿©ÇàÁöÃß°¡");
		temp.setBounds(500, 20, 250,300);
		temp.setVisible(true);
		
		String[] tempString = {"¸ÀÁý", "°ü±¤", "ÈÞ½Ä"};
		JComboBox<String> tempBox = new JComboBox<String>(tempString);
		tempBox.setBounds(80, 30, 70, 30);
		temp.add(tempBox);
		
		tempData = new TPData("6", 1, 20, 22);
				
		return tempData;
	}
	
	private void addArea(TPData newData) {
		if(newData != null) {
			lastArea.setRight(newData);
			newData.setLeft(lastArea);
			newData.setRight(null);
			lastArea = newData;
		}
	}
	
	private void removeArea(TPData removeData) {
		if(removeData.getLeft() == null && removeData.getRight() == null) {
			firstArea = lastArea = null;
		} else if(removeData.getLeft() == null) {
			removeData.getRight().setLeft(null);
			firstArea = removeData.getRight();
		} else if(removeData.getRight() == null) {
			removeData.getLeft().setRight(null);
			lastArea = removeData.getLeft();
		} else {
			removeData.getRight().setLeft(removeData.getLeft());
			removeData.getLeft().setRight(removeData.getRight());
		}
		
		repaint();
	}
	
	private void changeArea(TPData changeData1, TPData changeData2) {
		
		TPData left1 = changeData1.getLeft();
		TPData right1 = changeData1.getRight();
		TPData left2 = changeData2.getLeft();
		TPData right2 = changeData2.getRight();
		
		if(left1 != null) {
			left1.setRight(changeData2);
			changeData2.setLeft(left1);
		} else {
			changeData2.setLeft(null);
			firstArea = changeData2;
		}
		if(right1 != null) {
			right1.setLeft(changeData2);
			changeData2.setRight(right1);
		} else {
			changeData2.setRight(null);
			lastArea = changeData2;
		}
		if(left2 != null) {
			left2.setRight(changeData1);
			changeData1.setLeft(left2);
		} else {
			changeData1.setLeft(null);
			firstArea = changeData1;
		}
		if(right2 != null) {
			right2.setLeft(changeData1);
			changeData1.setRight(right2);
		} else {
			changeData1.setRight(null);
			lastArea = changeData1;
		}
		
		repaint();
	}
	
	public void showCourses() {
		TPData temp;
		int x = 10, y = 100, width = 50, height = 30;
		for(temp = firstArea; temp != null; temp = temp.getRight()) {
			temp.setBounds(x, y, width, height);
			temp.drawCourse(getGraphics());
			x += 70;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		showCourses();
	}
	
	@Override
	public void paintAll(Graphics g) {
		super.paint(g);
		TPData temp;
		int x = 10, y = 100, width = 50, height = 30;
		for(temp = firstArea; temp != null; temp = temp.getRight()) {
			temp.setBounds(x, y, width, height);
			temp.drawCourse(getGraphics());
			x += 70;
		}
	}
	
	public void makeCourses() {
		firstArea = new TPData("1", 1, 10, 12);
		lastArea = firstArea;
		this.addArea(new TPData("2", 1, 12, 13));
		this.addArea(new TPData("3", 1, 13, 15));
		this.addArea(new TPData("4", 1, 15, 18));
		this.addArea(new TPData("5", 1, 18, 20));
	}
	
	private class MouseHandler implements MouseListener {

		private TPData change1 = null;
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(removeBtn)) {
				currentState = EState.remove;
			} else if(e.getSource().equals(changeBtn)) {
				currentState = EState.change1;
			} else if(currentState == EState.remove) {
				TPData temp;
				for(temp = firstArea; temp != null; temp = temp.getRight()) {
					if(temp.contain(e.getX(), e.getY())) {
						removeArea(temp);
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) { }

		@Override
		public void mouseExited(MouseEvent e) {	}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(currentState == EState.change1) {
				TPData temp;
				for(temp = firstArea; temp != null; temp = temp.getRight()) {
					if(temp.contain(e.getX(), e.getY())) {
						change1 = temp;
						System.out.println(change1.getStartTime());
						currentState = EState.change2;
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(currentState == EState.change2) {
				TPData temp;
				for(temp = firstArea; temp != null; temp = temp.getRight()) {
					if(temp.contain(e.getX(), e.getY())) {
						System.out.println(temp.getStartTime());
						changeArea(change1, temp);
						change1 = null;
						currentState = EState.idle;
					}
				}
			}
		}
		
	}
}
