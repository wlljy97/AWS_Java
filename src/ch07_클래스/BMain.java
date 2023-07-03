package ch07_클래스;

public class BMain {
	public static void main(String[] args) {
		//("  ") ""는 함수
		// 메소드는 return을 이용해서 올라간다
		
		B b1 = new B();
		b1.test1(); // 메소드 , 함수의 호출이라고 한다
		
		System.out.println("=======================");
		
		int num1 = b1.test2(); // <- 정수 값 
		System.out.println("=======================");
		System.out.println(num1);
		System.out.println(b1.test2()); // 메소드를 호출 후 리턴 을 하여 정수 값도 나온다.
		
		if(b1.test3()){ // boolean 을 사용해서 if를 이용해 논리형을 받아서 참이 나오면 실행하게 한다.
			System.out.println("if문을 실행");
		}
		
		b1.test4("김준일", 30);
		b1.test4(30, "김준일");
		
	}

}
