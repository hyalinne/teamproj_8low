package data;

public enum ESleepingData {
	first(new TPData("ȣ�ڽó׸�", "�޽�"), "��⵵ ���ν� ó�α� ������ 1102", "031-335-5454", "�ֺ� ��ġ : ���νÿܹ����͹̳� �ǳ���"),
	second(new TPData("���׸���", "�޽�"), "��⵵ ���ν� ó�α� ������ ������148���� 11", "031-322-6760", "��� �̿�ð� : 3�ð�, �����ð� : 23:00����"),
	third(new TPData("����������쳪", "�޽�"), "��⵵ ���ν� ó�α� �ݷɷ� 71���� 8", "031-338-5488", "�ֺ� ���������� : ó�α�û.���γ���(29-420)"),
	forth(new TPData("�����ȣ��", "�޽�"), "��⵵ ���ν� ó�α� ������ �����78���� 23 ȣ���׸�", "031-336-3563", "�ֺ� ���������� : ���������Ա�(47-459), ���߹���"),
	fifth(new TPData("ȣ�ڿ��̽�", "�޽�"), "��⵵ ���ν� ���ﱸ �Ű��� 5-15", "031-281-1421", "�ֺ� ���������� : ��⵵�ڹ����Ա� (29-172)"),
	sixth(new TPData("��������ȣ��", "�޽�"), "��⵵ ���ν� ���ﱸ ����3�� 11���� 43", "031-284-3435", "�̿�ð� : üũ��15:00, üũ�ƿ�11:00");
	
	
	private TPData myData;
	
	private ESleepingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}