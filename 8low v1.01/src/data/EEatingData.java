package data;

public enum EEatingData {
	first(new TPData("���ں���", "����"), "��⵵ ���ν� ó�α� ��ϸ� ��Ϸ� 202 ������", "031-322-7057", "�ֺ� ���������� : ����͹̳�(29-712)"),
	second(new TPData("����", "����"), "��⵵ ���ν� ó�α� ������ 91", "070-8874-4497", "�̿�ð� : 11:00~ 24:00, �ֺ����� ������ �������б�(47-946)"),
	third(new TPData("ġŲ������", "����"), "��⵵ ���ν� ó�α� ������116���� 8 ��������", "031-339-7225", "�̿�ð� : 12:30~23:30 �Ͽ��� �޹�"),
	forth(new TPData("�ְ�����", "����"), "��⵵ ���ν� ó�α� ������ 77-2", "031-323-0058", "�ֺ� ���� ������ : �������(47-632)"),
	fifth(new TPData("�������ű�", "����"), "��⵵ ���ν� ó�α� ���ϵ�", "x", "�ֺ� ���������� : �����ʵ��б�.��ȯ�����(29-409)"),
	sixth(new TPData("���â��", "����"), "��⵵ ���ν� ���ﱸ �������� 6 �׷���������", "050-7724-7371", "�̿�ð� : 11:00~23:00 �Ͽ��� �޹�");
	
	private TPData myData;
	
	private EEatingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}