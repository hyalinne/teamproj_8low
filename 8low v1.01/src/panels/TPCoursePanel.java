package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
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
import data.EEatingData;
import data.ESeeingData;
import data.ESleepingData;
import data.TPButton;
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
	
	private ArrayList<TPData> courseList;
	private TPUndoStack undoStack;
	private TPRedoStack redoStack;
	
	private MouseListener mouseListener;
	private JButton addBtn;
	private JButton removeBtn;
	private JButton changeBtn;
	private JButton undoBtn;
	private JButton redoBtn;
	private JButton saveBtn;
	private JButton loadBtn;
	private JDialog addDialog;
	
	private TPData selectData;
	
	private TPTimePanel timePanel;

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
		
		this.addDialog = new JDialog();
		this.addDialog.setLayout(null);
		this.addDialog.setTitle("¿©ÇàÁöÃß°¡");
		this.addDialog.setBounds(500, 20, 230, 300);
		
		this.undoStack = new TPUndoStack();
		this.redoStack = new TPRedoStack();
		
		this.courseList = new ArrayList<TPData>();
		this.selectData = null;
	}
	
	public void init(TPTimePanel timePanel) {
		this.drawCourses();
		this.timePanel = timePanel;
	}
	
	public ArrayList<TPData> getCourse() {return this.courseList;}
	
	public void updataTimePanel() {
		timePanel.setData(courseList);
	}
	
	private void makeButtons() {
		this.addBtn = new JButton();
		this.addBtn.setIcon(new ImageIcon("rsc/+.png"));
		this.addBtn.setBounds(TPConstants.COURSE_BUTTON_X, TPConstants.C_BUTTON_Y, TPConstants.COURSE_BUTTON_WIDTH, TPConstants.C_BUTTON_HEIGHT);
		this.addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addData();
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
	}
	
	private void drawCourses() {
		this.removeAll();
		this.makeButtons();
		int x = 20, y = 100, width = 90, height = 120;
		for(TPData course : this.courseList) {
			TPButton temp = new TPButton();
			temp.setData(course);
			temp.setBounds(x, y, width, height);
			temp.setIcon(course.getIcon());
			temp.setBackground(Color.WHITE);
			temp.setOpaque(false);
			temp.setBorderPainted(false);
			temp.setFocusPainted(false);
			temp.addMouseListener(mouseListener);
			temp.setLabel(course.getName());
			this.add(temp);
			x += 120;
			if(x == 620) {
				y = 240;
				x = 10;
			}
			
		}
	}
	
	private void addData() {
		this.addDialog.setVisible(true);
		
		String[] tempString = {"¼±ÅÃ", "¸ÀÁý", "°ü±¤", "ÈÞ½Ä"};
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
				} else {
					addDialog.removeAll();
					addDialog.repaint();
				}
			}
		});
		this.addDialog.add(tempBox);
		
		JButton submitButton = new JButton("È®ÀÎ");
		submitButton.setBounds(80, 220, 70, 30);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(selectData != null) {
					addArea(selectData);
					drawCourses();
					repaint();
				}
				addDialog.setVisible(false);
			}
		});
		this.addDialog.add(submitButton);
	}
	
	private void removeList() {
		for(Component temp : this.addDialog.getRootPane().getContentPane().getComponents()) {
			if(temp.getClass().getSimpleName().equals("TPButton")) {
				this.addDialog.remove(temp);
			}
		}
		this.addDialog.repaint();
	}
	
	private enum EDialogBounds {
		first(30, 70, 70, 30),
		secon(30, 120, 70, 30),
		third(30, 170, 70, 30),
		forth(110, 70, 70, 30),
		fifth(110, 120, 70, 30),
		sixth(110, 170, 70, 30);
		
		private int x, y, width, height;
		private EDialogBounds(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
		}
		public Rectangle getBounds() {return new Rectangle(x,y,width,height);}
	}
	
	private void addList(String theme) {
		removeList();
		if(theme == "¸ÀÁý") {
			for(int i = 0; i < 6; i++) {
				TPButton temp = new TPButton();
				temp.setBounds(EDialogBounds.values()[i].getBounds());
				temp.setData(EEatingData.values()[i].getData());
				temp.setText(EEatingData.values()[i].getData().getName());
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						selectData = ((TPButton) e.getSource()).getData();
					}
				});
				this.addDialog.add(temp);
			}
		} else if(theme == "°ü±¤") {
			for(int i = 0; i < 6; i++) {
				TPButton temp = new TPButton();
				temp.setBounds(EDialogBounds.values()[i].getBounds());
				temp.setData(ESeeingData.values()[i].getData());
				temp.setText(ESeeingData.values()[i].getData().getName());
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						selectData = ((TPButton) e.getSource()).getData();
					}
				});
				this.addDialog.add(temp);
			}
		} else if(theme == "ÈÞ½Ä") {
			for(int i = 0; i < 6; i++) {
				TPButton temp = new TPButton();
				temp.setBounds(EDialogBounds.values()[i].getBounds());
				temp.setData(ESleepingData.values()[i].getData());
				temp.setText(ESleepingData.values()[i].getData().getName());
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						selectData = ((TPButton) e.getSource()).getData();
					}
				});
				this.addDialog.add(temp);
			}
		}
		this.addDialog.repaint();
	}
	
	// course change
	
	private void addArea(TPData newData) {
		this.undoStack.push(courseList);
		if(newData != null) {
			if(courseList.size() < 10) {
				this.courseList.add(newData);
			}
		}
		this.updataTimePanel();
	}
	
	private void removeArea(TPData removeData) {
		this.undoStack.push(courseList);
		if(removeData != null) {
			this.courseList.remove(removeData);
		}
		this.updataTimePanel();
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
		this.updataTimePanel();
	}
	
	// undo & redo
	
	private void undo() {
		this.redoStack.push(this.courseList);
		ArrayList<TPData> temp = this.undoStack.pop();
		if(temp != null) {
			this.courseList = temp;
		}
		this.drawCourses();
		this.repaint();
		this.updataTimePanel();
	}
	
	private void redo() {
		this.undoStack.push(this.courseList);
		ArrayList<TPData> temp = this.redoStack.pop();
		if(temp != null) {
			this.courseList = temp;
		}
		this.drawCourses();
		this.repaint();
		this.updataTimePanel();
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
		this.drawCourses();
		this.repaint();
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
				if(e.getSource().getClass().getSimpleName().equals("TPButton")) {
					removeArea(((TPButton) e.getSource()).getData());
					drawCourses();
					repaint();
				}
			} else if(currentState == EState.change1) {
				if(e.getSource().getClass().getSimpleName().equals("TPButton")) {
					change1 = ((TPButton) e.getSource()).getData();
					currentState = EState.change2;
				}
			} else if(currentState == EState.change2) {
				if(e.getSource().getClass().getSimpleName().equals("TPButton")) {
					changeArea(change1, ((TPButton) e.getSource()).getData());
					drawCourses();
					repaint();
					change1 = null;
					currentState = EState.idle;
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
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
}
