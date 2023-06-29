package ch03_연산자;


/*
 * 논리연산자
 *  1. && -> and(그리고) - 곱
 *  true && false => false
 *  true && true => true
 *  
 *  2. || -> or(또는) 	 - 합
 *  true || false => true
 *  
 *  3. !  -> not(부정) 	 - 반전
 *  !(true || false) => false
 *  !true => false
 */
public class Operator02 {

	public static void main(String[] args) {
		// final을 쓰면은 상수 , 상수는 무조건 한번 초기화가 되어야함 
		final int MAX = 100;
		final int MIN = 0;
		int num = -10;
		
		// System.out.println(MIN < num < MAX); 비교연산자는 2항 연산자이므로 이렇게쓰면 안된다
		System.out.println(MIN < num && MAX > num); // 위의 내용을 이런식으로 나타내야한다
		
		System.out.println(MAX < num);
		
		System.out.println("===========================");
		
		int year = 1999;
		System.out.println(year % 4 == 0 );
		System.out.println(year % 100 != 0);
		System.out.println(year % 400 == 0);
		System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0);
		
		int result = 10 + 1;
		System.out.println(result);
		
		boolean result2 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		System.out.println(result2);
		
		String result3 = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "1" : "0"; // 자료형에 맞게끔 나타난다
		System.out.println(result3);
		
	}

}
