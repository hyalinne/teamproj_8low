package data;

public enum EEatingData {
	first(new TPData("���ں���", "����")),
	second(new TPData("����", "����")),
	third(new TPData("ġŲ������", "����")),
	forth(new TPData("�ְ�����", "����")),
	fifth(new TPData("�������ű�", "����")),
	sixth(new TPData("���â��", "����"));
	
	private TPData myData;
	
	private EEatingData(TPData data) {
		this.myData = data;
	}
	public TPData getData() {return this.myData;}
}
