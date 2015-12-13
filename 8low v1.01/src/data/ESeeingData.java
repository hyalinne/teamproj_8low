package data;

public enum ESeeingData {
	first(new TPData("에버랜드", "관광"), "경기도 용인시 처인구 포곡읍 에버랜드로 199", "031-320-5000", "이용시간 : 10:00 ~ 20:00"),
	second(new TPData("용인 한국 민속촌", "관광"), "경기도 용인시 기흥구 민속촌로 90 한국민속촌", "031-288-0000", "이용시간 : 매일09:00~ 18:30"),
	third(new TPData("용인 자연휴양림", "관광"), "경기도 용인시 처인구 모현면 초부로 220", "031-336-0040", "이용시간 : 09~18:00공휴일포함"),
	forth(new TPData("와우정사", "관광"), "경기도 용인시 처인구 해곡동 183", "031-332-2472", "주변 버스정류장 : 해곡동 (47-638)"),
	fifth(new TPData("용인대장금파크", "관광"), "경기도 용인시 처인구 백암면 용천로 330 MBC드라미아", "031-337-3241", "이용시간 09:00~17:00(동절기)18:00(하절기)"),
	sixth(new TPData("농도원 목장", "관광"), "경기도 용인시 처인구 원삼면 사암리 542-1", "031-321-0445", "체험기간 : 장마철제외, 2월(동계체험) ");
	
	private TPData myData;
	
	private ESeeingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}