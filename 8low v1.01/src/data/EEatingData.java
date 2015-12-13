package data;

public enum EEatingData {
	first(new TPData("돈코복코", "맛집"), "경기도 용인시 처인구 백암면 백암로 202 계경목장", "031-322-7057", "주변 버스정류장 : 백암터미널(29-712)"),
	second(new TPData("먹핑", "맛집"), "경기도 용인시 처인구 명지로 91", "070-8874-4497", "이용시간 : 11:00~ 24:00, 주변버스 정류장 명지대학교(47-946)"),
	third(new TPData("치킨마스터", "맛집"), "경기도 용인시 처인구 명지로116번길 8 성현빌딩", "031-339-7225", "이용시간 : 12:30~23:30 일요일 휴무"),
	forth(new TPData("솔가의집", "맛집"), "경기도 용인시 처인구 명지로 77-2", "031-323-0058", "주변 버스 정류장 : 명지대앞(47-632)"),
	fifth(new TPData("마포갈매기", "맛집"), "경기도 용인시 처인구 역북동", "x", "주변 버스정류장 : 역북초등학교.삼환나우빌(29-409)"),
	sixth(new TPData("고기창고", "맛집"), "경기도 용인시 기흥구 강남동로 6 그랜드프라자", "050-7724-7371", "이용시간 : 11:00~23:00 일요일 휴무");
	
	private TPData myData;
	
	private EEatingData(TPData data, String addr, String pN, String con) {
		this.myData = data;
		this.myData.setAddress(addr);
		this.myData.setPhoneNum(pN);
		this.myData.setContent(con);
	}
	public TPData getData() {return this.myData;}
}