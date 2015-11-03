package data;

public class TPData {
		private String name, address, tel, theme, content, link;
		private float distance;
		
		public TPData() {
			name = address = tel = theme = content = link = null;
			distance = 0;
		}

		public String getName() {return name;}
		public String getAddress() {return address;}
		public String getTel() {return tel;}
		public String getTheme() {return theme;}
		public String getContent() {return content;}
		public String getLink() {return link;}
		public float getDistance() {return distance;}
		
		public void setName(String name) {this.name = name;}
		public void setAddress(String address) {this.address = address;}
		public void setTel(String tel) {this.tel = tel;}
		public void setTheme(String theme) {this.theme = theme;}
		public void setContent(String content) {this.content = content;}
		public void setLink(String link) {this.link = link;}
		public void setDistance(float distance) {this.distance = distance;}
		
}
