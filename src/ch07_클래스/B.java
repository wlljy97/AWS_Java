package ch07_클래스;

public class B {
	// void : 반환이 없다
	
	// 반환x 매개변수x
	void test1() {
		System.out.println("test1 메소드 호출");
	}
	
	// 반환(정수를 반환) 매개변수x
	int test2() {
		System.out.println("test2 메소드 호출");
		return 100;
	}
	// 반환(논리 반환) 매개변수x
	boolean test3() {
		System.out.println("test3 메소드 서비스를 실행합니다.");
		return test2() == 100;
	}
	
	void test4(String name, int age) {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
	// ↓오버로딩 : '매개변수의 형태가 다르면' 똑같은 메소드를 사용가능 (생성자를 만들 때 많이 사용)
	// 매개 변수의 자료형이 달라야 오버로딩이 된다, 자료형을 따라가야한다.
	
	void test4(int age, String name) {
		System.out.println("나의 이름 : " + name);
		System.out.println("나의 나이 : " + age);
	}
	
	
	
}
