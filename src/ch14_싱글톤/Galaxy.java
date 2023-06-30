package ch14_싱글톤;

// 싱글톤
// '하나의 유일한 객체를 만드는 것', 그 객체만 쓰겠다.
// '어디서나' 이 객체를 쉽게 사용 하겠다.
// static 을 이용
// 디자인 패턴 중에 생성패턴

public class Galaxy {
	private int serialNumber;
	private String model;
	
	public Galaxy(int serialNumber, String model) {
		this.serialNumber = serialNumber;
		this.model = model;
	}
	
	public void showInfo() {
		System.out.println("시리얼번호 : " + serialNumber);
		System.out.println("모델명 : " + model);
	}
}
