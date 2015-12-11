package data;

public enum EEatingData {
	first(new TPData("돈코복코", "맛집")),
	second(new TPData("먹핑", "맛집")),
	third(new TPData("치킨마스터", "맛집")),
	forth(new TPData("솔가의집", "맛집")),
	fifth(new TPData("마포갈매기", "맛집")),
	sixth(new TPData("고기창고", "맛집"));
	
	private TPData myData;
	
	private EEatingData(TPData data) {
		this.myData = data;
	}
	public TPData getData() {return this.myData;}
}
