package data;

import java.awt.Point;

public class TPData {
	public enum EData {
		date1("처인구", "맛집", "이름", 5, new Point(2,3));
		
		String region, theme, name;
		int score; // 1 - 5 score, 5 is best
		Point coordinate;
		private EData(String region, String theme, String name, int score, Point coordinate) {
			this.region = region;
			this.theme = theme;
			this.score = score;
			this.coordinate = coordinate;
		}
		public String getRegion() {return region;}
		public String getTheme() {return theme;}
		public String getName() {return name;}
	}
}
