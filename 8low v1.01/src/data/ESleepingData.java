package data;

public enum ESleepingData {
	first(new TPData("È£ÅÚ½Ã³×¸¶", "ÈÞ½Ä")),
	second(new TPData("¼§±×¸®¾Æ", "ÈÞ½Ä")),
	third(new TPData("½ºÆÄ", "ÈÞ½Ä")),
	forth(new TPData("¸ô¶ó", "ÈÞ½Ä")),
	fifth(new TPData("¾Ë¾Æ¼­", "ÈÞ½Ä")),
	sixth(new TPData("ÇÏ°ÚÁö", "ÈÞ½Ä"));
	
	private TPData myData;
	
	private ESleepingData(TPData data) {
		this.myData = data;
	}
	public TPData getData() {return this.myData;}
}
