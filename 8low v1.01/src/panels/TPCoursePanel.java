package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import constants.TPConstants;
import data.TPData;
import data.TPFileManager;
import frame.TPRedoStack;
import frame.TPUndoStack;

public class TPCoursePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private enum EState {idle, remove, change1, change2};
	private EState currentState;
	private String currenetPath;
	private String currentFileName;
	
	private MouseListener mouseListener;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton changeBtn;
	private JButton undoBtn;
	private JButton redoBtn;
	private JButton saveBtn;
	private JButton loadBtn;
	private JDialog addDialog;
	
	private TPUndoStack undoStack;
	private TPRedoStack redoStack;
	
	private ArrayList<TPData> courseList;

	public TPCoursePanel() {
		this.currentState = EState.idle;

		this.currenetPath = "./workspace";
		this.currentFileName = null;
		
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setLocation(0,TPConstants.MAIN_BUTTON_HEIGHT);
		this.setSize(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT);
		this.mouseListener = new MouseHandler();
		this.addMouseListener(mouseListener);
		
		this.addBtn = new JButton();
		this.addBtn.setIcon(new ImageIcon("rsc/+.png"));
		this.addBtn.setBounds(TPConstants.COURSE_BUTTON_X, TPConstants.C_BUTTON_Y, TPConstants.COURSE_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addArea(addData());
			}
		});
		this.add(addBtn);
		
		this.removeBtn = new JButton("-");
		this.removeBtn.setBounds(TPConstants.COURSE_BUTTON_X, TPConstants.C_BUTTON_Y + (TPConstants.C_BUTTON_HEIGHT + TPConstants.C_BUTTON_SPACE) * 1
				, TPConstants.COURSE_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.removeBtn.addMouseListener(mouseListener);
		this.add(removeBtn);
		
		this.changeBtn = new JButton();
		this.changeBtn.setIcon(new ImageIcon("rsc/changebutton.png"));
		this.changeBtn.setBounds(TPConstants.COURSE_BUTTON_X, TPConstants.C_BUTTON_Y + (TPConstants.C_BUTTON_HEIGHT + TPConstants.C_BUTTON_SPACE) * 2
				, TPConstants.COURSE_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.changeBtn.addMouseListener(mouseListener);
		this.add(changeBtn);
		
		this.undoBtn = new JButton("Undo");
		this.undoBtn.setBounds(TPConstants.DO_BUTTON_X, TPConstants.C_BUTTON_Y + (TPConstants.C_BUTTON_HEIGHT + TPConstants.C_BUTTON_SPACE) * 2 + TPConstants.C_BUTTON_WIDE_SPACE * 1
				, TPConstants.DO_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.undoBtn.addMouseListener(mouseListener);
		this.add(undoBtn);
		
		this.redoBtn = new JButton("Redo");
		this.redoBtn.setBounds(TPConstants.DO_BUTTON_X, TPConstants.C_BUTTON_Y + (TPConstants.C_BUTTON_HEIGHT + TPConstants.C_BUTTON_SPACE) * 3 + TPConstants.C_BUTTON_WIDE_SPACE * 1
				, TPConstants.DO_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.redoBtn.addMouseListener(mouseListener);
		this.add(redoBtn);
		
		this.saveBtn = new JButton("Save");
		this.saveBtn.setBounds(TPConstants.DO_BUTTON_X, TPConstants.C_BUTTON_Y + (TPConstants.C_BUTTON_HEIGHT + TPConstants.C_BUTTON_SPACE) * 3 + TPConstants.C_BUTTON_WIDE_SPACE * 2
				, TPConstants.DO_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.saveBtn.addMouseListener(mouseListener);
		this.add(saveBtn);
		
		this.loadBtn = new JButton("Load");
		this.loadBtn.setBounds(TPConstants.DO_BUTTON_X, TPConstants.C_BUTTON_Y + (TPConstants.C_BUTTON_HEIGHT + TPConstants.C_BUTTON_SPACE) * 4 + TPConstants.C_BUTTON_WIDE_SPACE * 2
				, TPConstants.DO_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.loadBtn.addMouseListener(mouseListener);
		this.add(loadBtn);
		
		this.addDialog = new JDialog();
		this.addDialog.setLayout(null);
		this.addDialog.setTitle("¿©ÇàÁöÃß°¡");
		this.addDialog.setBounds(500, 20, 250,300);
		
		this.undoStack = new TPUndoStack();
		this.redoStack = new TPRedoStack();
		
		this.courseList = new ArrayList<TPData>();
	}
	
	public void init() {
		this.makeCourses();
	}
	
	public void makeCourses() {
		this.courseList.add(new TPData("1", 1, 10, 12));
		this.courseList.add(new TPData("2", 1, 12, 13));
		this.courseList.add(new TPData("3", 1, 13, 15));
		this.courseList.add(new TPData("4", 1, 15, 18));
		this.courseList.add(new TPData("5", 1, 18, 20));
	}
	
	private TPData addData() {
		this.addDialog.setVisible(true);
		
		TPData selectData = null;
		String[] tempString = {"¸ÀÁý", "°ü±¤", "ÈÞ½Ä"};
		JComboBox<String> tempBox = new JComboBox<String>(tempString);
		tempBox.setBounds(80, 30, 70, 30);
		tempBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tempBox.getSelectedItem().equals("¸ÀÁý")) {
					addList("¸ÀÁý");
				} else if(tempBox.getSelectedItem().equals("°ü±¤")) {
					addList("°ü±¤");
				} else if(tempBox.getSelectedItem().equals("ÈÞ½Ä")) {
					addList("ÈÞ½Ä");
				}
			}
		});
		this.addDialog.add(tempBox);
		
		selectData = new TPData("6", 1, 20, 22);
		
		return selectData;
	}
	
	private void addList(String theme) {
		if(theme == "¸ÀÁý") {
			
		} else if(theme == "°ü±¤") {
			
		} else if(theme == "ÈÞ½Ä") {
			
		}
	}
	
	// course change
	
	private void addArea(TPData newData) {
		this.undoStack.push(courseList);
		if(newData != null) {
			this.courseList.add(newData);
		}
		repaint();
	}
	
	private void removeArea(TPData removeData) {
		this.undoStack.push(courseList);
		if(removeData != null) {
			this.courseList.remove(removeData);
		}
		
		repaint();
	}
	
	private void changeArea(TPData changeData1, TPData changeData2) {
		if(changeData1 == changeData2) {
			return;
		}
		
		this.undoStack.push(courseList);
		
		ArrayList<TPData> newList = new ArrayList<TPData>();
		int index1, index2;
		for(index1 = 0; index1 < this.courseList.size(); index1++) {
			if(this.courseList.get(index1).equals(changeData1)) {
				break;
			}
		}
		for(index2 = 0; index2 < this.courseList.size(); index2++) {
			if(this.courseList.get(index2).equals(changeData2)) {
				break;
			}
		}
		for(int i = 0; i < this.courseList.size(); i++) {
			if(i == index1) {
				newList.add(changeData2);
			} else if(i == index2) {
				newList.add(changeData1);
			} else {
				newList.add(this.courseList.get(i));
			}
		}
		this.courseList = newList;
		
		repaint();
	}
	
	// undo & redo
	
	private void undo() {
		this.redoStack.push(this.courseList);
		ArrayList<TPData> temp = this.undoStack.pop();
		if(temp != null) {
			this.courseList = temp;
		}
		repaint();
	}
	
	private void redo() {
		this.undoStack.push(this.courseList);
		ArrayList<TPData> temp = this.redoStack.pop();
		if(temp != null) {
			this.courseList = temp;
		}
		this.repaint();
	}
	
	// save & load
	
	enum EDialogType { OPEN, SAVE, NONE };
	private int showDialog(EDialogType eDialogType) {
	    JFileChooser chooser = new JFileChooser(this.currenetPath);
	    FileNameExtensionFilter filter = 
	    		new FileNameExtensionFilter("Travle Planner Course", "tpc");
	    chooser.setFileFilter(filter);
	    int returnVal = JFileChooser.ERROR_OPTION;
	    
	    if (eDialogType == EDialogType.OPEN) {
	    	returnVal = chooser.showOpenDialog(null);
	    } else if (eDialogType == EDialogType.SAVE) {
	    	returnVal = chooser.showSaveDialog(null);	    	
	    } 
	    
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	this.currenetPath = chooser.getSelectedFile().getParent();
	    	this.currentFileName = currenetPath + "\\" + chooser.getSelectedFile().getName();
	    }
	    return returnVal;
	}
	
	private void save() {
		int returnVal = this.showDialog(EDialogType.SAVE);
	    if( returnVal == JFileChooser.APPROVE_OPTION) {
	    	if (!this.currentFileName.endsWith("." + "tpc")) {
	    		this.currentFileName = this.currentFileName + "." + "tpc";
	    	}
			try {
				TPFileManager.write(currentFileName, this.courseList);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.repaint();
	    }
	}
	
	@SuppressWarnings("unchecked")
	private void load() {
		int returnVal = this.showDialog(EDialogType.OPEN);
	    if( returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				this.courseList = (ArrayList<TPData>) TPFileManager.read(currentFileName);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int x = 10, y = 100, width = 50, height = 30;
		for(TPData course : this.courseList) {
			course.setBounds(x, y, width, height);
			course.draw(getGraphics());
			x += 70;
		}
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
			} else if(e.getSource().equals(undoBtn)) {
				undo();
			} else if(e.getSource().equals(redoBtn)) {
				redo();
			} else if(e.getSource().equals(saveBtn)) {
				save();
			} else if(e.getSource().equals(loadBtn)) {
				load();
			} else if(currentState == EState.remove) {
				for(int i = 0; i < courseList.size(); i++) {
					if(courseList.get(i).contain(e.getX(), e.getY())) {
						removeArea(courseList.get(i));
						break;
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
				for(int i = 0; i < courseList.size(); i++) {
					if(courseList.get(i).contain(e.getX(), e.getY())) {
						change1 = courseList.get(i);
						currentState = EState.change2;
						break;
					}
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(currentState == EState.change2) {
				for(int i = 0; i < courseList.size(); i++) {
					if(courseList.get(i).contain(e.getX(), e.getY())) {
						changeArea(change1, courseList.get(i));
						change1 = null;
						currentState = EState.idle;
						break;
					}
				}
			}
		}
		
	}
}
