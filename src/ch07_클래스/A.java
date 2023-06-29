package ch07_클래스;

public class A {
	// 클래스안에 있는것을 메소드 / 자바는 클래스로 다 만들어짐
	
	int num1;
	int num2;
	
	void test1() {
		System.out.println("테스트1 함수 호출");
	}
	
	void test2(int x, int y) {
		System.out.println("x값 : " + x);
		System.out.println("y값 : " + y);
	}
	
	void test3() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
	void test4() {
		System.out.println(num1 + num2);
	}
}
