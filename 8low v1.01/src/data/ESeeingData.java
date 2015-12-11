package data;

public enum ESeeingData {
	first(new TPData("¿¡¹ö·£µå", "°ü±¤"), "address", "hp", "content"),
	second(new TPData("¹Î¼ÓÃÌ", "°ü±¤"), "address", "hp", "content"),
	third(new TPData("ÀÚ¿¬³ó¿ø", "°ü±¤"), "address", "hp", "content"),
	forth(new TPData("Àú¼öÁö", "°ü±¤"), "address", "hp", "content"),
	fifth(new TPData("ÇÔ¹Ú»ê", "°ü±¤"), "address", "hp", "content"),
	sixth(new TPData("¸íÁö´ë", "°ü±¤"), "address", "hp", "content");
	
	private TPData myData;
	
	private ESeeingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}
