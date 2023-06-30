package ch17_추상;

public interface Button {
	// interface 기능
	// interface 안에는 추상메소드 일반 변수를 줄 수 없고 static 상수 만 사용가능
	// 다른 클래스를 작성할 때 기본이 되는 틀을 제공
	
	
	
	public int ButtonCount = 4;
	
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
	
}
