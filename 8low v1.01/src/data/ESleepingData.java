package data;

public enum ESleepingData {
	first(new TPData("ȣ�ڽó׸�", "�޽�")),
	second(new TPData("���׸���", "�޽�")),
	third(new TPData("����", "�޽�")),
	forth(new TPData("����", "�޽�")),
	fifth(new TPData("�˾Ƽ�", "�޽�")),
	sixth(new TPData("�ϰ���", "�޽�"));
	
	private TPData myData;
	
	private ESleepingData(TPData data) {
		this.myData = data;
	}
	public TPData getData() {return this.myData;}
}
