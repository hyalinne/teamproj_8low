package panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.TPConstants;

public class TPTimePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	DefaultTableModel model;
	JScrollPane js;
	JTable timetable;
	JButton loadbtn;

	public TPTimePanel() {
		this.setBackground(Color.WHITE);
		this.setLocation(0,TPConstants.MAIN_BUTTON_HEIGHT);
		this.setSize(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT);
		
		String[] colName = { "矫埃", "厘家" };
		String[][] rowData = { { "8", "捣内焊内" }, { "9", "辆后" } };
		this.model = new DefaultTableModel(rowData, colName);
		this.timetable = new JTable(model);
		this.timetable.setPreferredScrollableViewportSize(new Dimension(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT));
		this.timetable.setRowHeight(50);

		this.js = new JScrollPane(timetable);
		this.add(this.js);
		
	}
	
	public void init() {
		this.makeTimeTable();
	}
	
	public void makeTimeTable() {
		
	}

}
