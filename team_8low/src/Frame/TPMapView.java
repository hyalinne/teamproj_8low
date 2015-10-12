package Frame;

public class TPMapView {
	private TPMapPanel mapPanel;
	private TPCalculator calc;
	
	public TPMapView(TPMapPanel mapPanel) {
		this.mapPanel = mapPanel;
		this.calc = TPCalculator.getInstance();
	}
	
	public void draw() {
		
	}
}
