package ch07_클래스;

public class AMain {
	public static void main(String[] args) {
//		int n = 10; // 10이라는 것은 int의 자료형
		
		A a = new A(); // new를 선언해서 자료형을 만듬, new는 생성하는 행위 주소를 담고 있다 그것을 A로 한다.
		System.out.println(a);
		
		System.out.println(a.num1);
		a.num1 = 10; // a. 에서 .이 a안의 자료를 나타내줌
		System.out.println(a.num1);
		
		a.num2 = 20;
		System.out.println(a.num2);
		
		A a2 = new A();
		System.out.println(a2);
		a2.num1 = 100;
		System.out.println(a.num1 + a2.num1);
		
		A a3 = new A();
		System.out.println(a3);
		a3.num1 = 50;
		a3.num2 = 40;
		
		System.out.println("==============================");
		
		a.test1();
		a.test2(1, 2);
		
		a.test3();
		a2.test3();
		
		a3.test4();
		a2.test3();
		
	}
}
