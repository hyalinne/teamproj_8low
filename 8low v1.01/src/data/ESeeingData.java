package data;

public enum ESeeingData {
	first(new TPData("��������", "����"), "address", "hp", "content"),
	second(new TPData("�μ���", "����"), "address", "hp", "content"),
	third(new TPData("�ڿ����", "����"), "address", "hp", "content"),
	forth(new TPData("������", "����"), "address", "hp", "content"),
	fifth(new TPData("�Թڻ�", "����"), "address", "hp", "content"),
	sixth(new TPData("������", "����"), "address", "hp", "content");
	
	private TPData myData;
	
	private ESeeingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}
