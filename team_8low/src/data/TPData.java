package data;

import java.awt.Point;

public class TPData {
	public enum EData {
		date1("¼­¿ï", "¸ÀÁý", 5, new Point(2,3));
		
		String region, theme;
		int score; // 1 - 5 score, 5 is best
		Point coordinate;
		private EData(String region, String theme, int score, Point coordinate) {
			this.region = region;
			this.theme = theme;
			this.score = score;
			this.coordinate = coordinate;
		}
	}
}
