package data;

public enum ESeeingData {
	first(new TPData("��������", "����"), "��⵵ ���ν� ó�α� ������ ��������� 199", "031-320-5000", "�̿�ð� : 10:00 ~ 20:00"),
	second(new TPData("���� �ѱ� �μ���", "����"), "��⵵ ���ν� ���ﱸ �μ��̷� 90 �ѱ��μ���", "031-288-0000", "�̿�ð� : ����09:00~ 18:30"),
	third(new TPData("���� �ڿ��޾縲", "����"), "��⵵ ���ν� ó�α� ������ �ʺη� 220", "031-336-0040", "�̿�ð� : 09~18:00����������"),
	forth(new TPData("�Ϳ�����", "����"), "��⵵ ���ν� ó�α� �ذ 183", "031-332-2472", "�ֺ� ���������� : �ذ (47-638)"),
	fifth(new TPData("���δ������ũ", "����"), "��⵵ ���ν� ó�α� ��ϸ� ��õ�� 330 MBC���̾�", "031-337-3241", "�̿�ð� 09:00~17:00(������)18:00(������)"),
	sixth(new TPData("�󵵿� ����", "����"), "��⵵ ���ν� ó�α� ����� ��ϸ� 542-1", "031-321-0445", "ü��Ⱓ : �帶ö����, 2��(����ü��) ");
	
	private TPData myData;
	
	private ESeeingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}