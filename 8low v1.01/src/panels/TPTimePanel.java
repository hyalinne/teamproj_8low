package panels;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import constants.TPConstants;
import data.TPData;

public class TPTimePanel extends JPanel {
   private static final long serialVersionUID = 1L;
   
   private DefaultTableModel model;
   private JScrollPane js;
   private JTable timetable;
   private JTableHeader header;
   private TPCoursePanel coursePanel;
   

   public TPTimePanel() {
      this.setBackground(Color.WHITE);
      this.setLocation(0,TPConstants.MAIN_BUTTON_HEIGHT);
      this.setSize(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT);
      
      String[] colName = { "시간", "장소", "내용", "비고" };
      String[][] rowData = {};
      
      this.model = new DefaultTableModel(rowData, colName);
      this.timetable = new JTable(model);
      
      this.timetable.getColumnModel().getColumn(0).setPreferredWidth(50);
      this.timetable.getColumnModel().getColumn(1).setPreferredWidth(150);
      this.timetable.getColumnModel().getColumn(2).setPreferredWidth(550);
      this.timetable.getColumnModel().getColumn(3).setPreferredWidth(50);
      header = this.timetable.getTableHeader();

      header.setPreferredSize(new Dimension(800,30));
      header.setForeground(Color.WHITE);
      header.setBackground(new Color(57, 172, 218));
      DefaultTableCellRenderer renderer =  (DefaultTableCellRenderer)this.timetable.getTableHeader().getDefaultRenderer();
      renderer.setHorizontalAlignment(SwingConstants.CENTER);
      this.timetable.getTableHeader().setDefaultRenderer(renderer);
      
      DefaultTableCellRenderer render = new DefaultTableCellRenderer(); 
      render.setHorizontalAlignment(SwingConstants.CENTER); 
      TableColumnModel tcm = timetable.getColumnModel();

      for(int i = 0 ; i < tcm.getColumnCount() ; i++){
      tcm.getColumn(i).setCellRenderer(render);  
      
      }
      
      this.timetable.setPreferredScrollableViewportSize(new Dimension(TPConstants.PANEL_WIDTH, TPConstants.PANEL_HEIGHT));
      
      this.timetable.setBackground(new Color(219, 238, 251));
      this.timetable.setRowHeight(50);
      this.timetable.setGridColor(Color.WHITE);
   
      this.js = new JScrollPane(timetable);
      this.add(this.js);
    
      
   }
   
   public void init(TPCoursePanel coursePanel) {
	   this.coursePanel = coursePanel;
	   ArrayList<TPData> list = coursePanel.getCourse();
	   this.setData(list);   
   }
   
   public void setData(ArrayList<TPData> list) {
	   int rowCount = this.model.getRowCount() + 1;
	   for(int i = 1; i < rowCount; i++) {
		   this.model.removeRow(0);
	   }
	   
	   String [][] temp = new String[list.size()][2];
	   int time = 8;
	   if(list != null ) {
		   for(int i = 0; i < list.size(); i++) {
			   temp[i][0] = Integer.toString(time);
			   temp[i][1] = list.get(i).getName();
			   list.get(i).setStartTime(time);
			   if(time == 20) time = 8;
			   time += 2;
		   }
	   }

	   for(int i = 0; i < list.size(); i++) {
		   this.model.insertRow(i, temp[i]);
	   }
   }

}