package Frame;

public class TPCalculator {
	private static TPCalculator calculatorInstance;
	private String selectedRegion, selectedTheme;
	
	private TPCalculator() {
		
	}
	
	public static TPCalculator getInstance() {
		if(calculatorInstance == null) {
			calculatorInstance = new TPCalculator();
		}
		return calculatorInstance;
	}

	public void calculate(String selectedRegion, String selectedTheme) {
		this.selectedRegion = selectedRegion;
		this.selectedTheme = selectedTheme;
	}
	
	public void dataSort() {
		
	}
	
	public void courseSort() {
		
	}

}
