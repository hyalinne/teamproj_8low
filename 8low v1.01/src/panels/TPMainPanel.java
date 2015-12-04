package panels;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;

public class TPMainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabPane;
	private TPHomePanel firstPanel;
	private TPCoursePanel secondPanel;
	private TPTimePanel thirdPanel;
	private TPRecommendPanel forthPanel;
	
	
	public TPMainPanel() {
		this.setLayout(null);
		this.tabPane = new JTabbedPane();
		tabPane.setFont(new Font("함초롬바탕", Font.PLAIN, 12));
		tabPane.setBackground(Color.WHITE);
		this.add(tabPane);
		this.tabPane.setBounds(0, 50, 700, 500);
		
		this.firstPanel = new TPHomePanel();
		this.tabPane.addTab("Home", firstPanel);
		
		this.secondPanel = new TPCoursePanel();
		this.secondPanel.init();
		this.tabPane.addTab("여행경로", secondPanel);
		
		this.thirdPanel = new TPTimePanel();
		this.tabPane.addTab("시간표", thirdPanel);
		
		this.forthPanel = new TPRecommendPanel();
		this.tabPane.addTab("추천", forthPanel);

	}
	
	public void init() {
		
	}
}
