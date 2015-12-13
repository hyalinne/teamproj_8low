package data;

public enum ESleepingData {
	first(new TPData("호텔시네마", "휴식"), "경기도 용인시 처인구 백옥대로 1102", "031-335-5454", "주변 위치 : 용인시외버스터미널 건너편"),
	second(new TPData("샹그리아", "휴식"), "경기도 용인시 처인구 양지면 양지로148번길 11", "031-322-6760", "대실 이용시간 : 3시간, 마감시간 : 23:00까지"),
	third(new TPData("골드빌보석사우나", "휴식"), "경기도 용인시 처인구 금령로 71번길 8", "031-338-5488", "주변 버스정류장 : 처인구청.용인농협(29-420)"),
	forth(new TPData("블루힐호텔", "휴식"), "경기도 용인시 처인구 포곡읍 전대로78번길 23 호텔테마", "031-336-3563", "주변 버스정류장 : 에버랜드입구(47-459), 연중무휴"),
	fifth(new TPData("호텔에이스", "휴식"), "경기도 용인시 기흥구 신갈로 5-15", "031-281-1421", "주변 버스정류장 : 경기도박물관입구 (29-172)"),
	sixth(new TPData("리디자인호텔", "휴식"), "경기도 용인시 기흥구 동백3로 11번길 43", "031-284-3435", "이용시간 : 체크인15:00, 체크아웃11:00");
	
	
	private TPData myData;
	
	private ESleepingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}