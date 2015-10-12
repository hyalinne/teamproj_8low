package Frame;

import data.TPData.EData;

public class TPMapView {
	private TPMapPanel mapPanel;
	private TPCalculator calc;
	private EData[] course;
	
	public TPMapView(TPMapPanel mapPanel) {
		this.mapPanel = mapPanel;
		this.calc = TPCalculator.getInstance();
	}
	
	public void setCourse(EData[] course) {this.course = course;}
	
	public void draw() {
		// course view
	}
}
