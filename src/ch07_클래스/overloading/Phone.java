package ch07_클래스.overloading;

public class Phone {
	
	// 오버로딩 : 메소드 명이 같다,  자료형의 따라서 여러 경우의 수를 만든다. 생성할 때 경우의 수를 고르면 된다.
	
	// 생성자 = 메소드
	
	public void send() {
		System.out.println("전송");
	}
	
	public void send(String message) {
		System.out.println("전송내용 : " + message);
	}
	
	public void send(String number, String message) {
		System.out.println(number + "에게" + message + "내용 전송");
	}
	
	public void send(String message, int count) {
		System.out.println(message + " 내용 " + count + "번 전송");
	}
	
}
