package ch12_상속;

public class Computer extends Product { // 상속의 개념은 자료형이 합쳐진거다
	private String type;
	
//	public Computer() {
//		super("", 10); // 상속시에 사용 생략되어있다(생략가능)
//	. super의 생성자가 먼저 나온다. 
//	(부모,상위)메모리의 주소. 값의 초기화가 일어나야한다(매개변수가 들어가야한다). this 대신에 넣는다.
//		System.out.println("컴퓨터 객체 생성");
//		
//	}
	
	
	public Computer(String model, int price) {
		super(model, price); // 부모를 생성할 때 쓰는것
	}
	
	public Computer(String model, int price, String type) {
		super(model, price);
		this.type = type;
	}
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
