package ch02_변수;

public class Variable {
	
		public static void main(String[] args) {
			// 변수 : 자료형 + 변수명
			// 변수명
			// 1. 변수 이름은 영문자(대,소문자)나 숫자를 사용할 수 있고 구분하며, 특수문자중에는 $,_만 사용가능 ex) 자료형 g_Level, 자료형 count100;, 자료형_master;
			// 2. 변수 이름은 숫자로 시작할 수 없다 ex) 자료형 27day;, 자료형 1abc;
			// 3. 자바에서 이미 사용 중인 예약어는 사용할 수 없다 ex) 자료형 while;, 자료형for;, 자료형int ;등
			
			// 자료형(↓)
			// 논리형 : boolean 값은 true or false
			// 문자형 : char
			
			// 정수형 : byte, short, int, long
			// long : long num = 1234567890L; 'l, L'표기 대부분 L로 표기
			
			// 실수형 : float, double
			// float : float fnum = 3.14F; 'F'표기
			
			boolean flag; // 선언
			flag = true;  // 초기화(대입)
			System.out.println("FLAG: " + flag);
			System.out.print("FLAG:");
			System.out.println(flag);
			
			char lastName = '김'; // 문자
			System.out.println(lastName);
			
			int number = 100; // 정수
			System.out.println("번호: " + number);
			
			double pi = 3.14; // 실수
			System.out.println(pi);
			
			String name = "김준일"; // 문자열
			System.out.println(name);
			
			String num1 = "10";
			int num2  = 10;
			System.out.println("String : " + num1);
			System.out.println("int : " + num2);
			System.out.println(num1 + num2); // 문자열 + 정수 (자료형이 달라서 1010으로 나옴)
			System.out.println(Integer.parseInt(num1) + num2); // 문자열을 Integer.parseInt()을 사용하여 정수형으로 형변환 시키면 20으로 나옴
			
			char num3 = '5';
			System.out.println(num3 + num2); // 아스키코드에서 문자(char)5는 (int)53을 뜻하기 때문에 값이 63이 나옴
			// 실수 > 정수 > 문자 (단위 크기)
			System.out.println(num3); 
			System.out.println((int)num3); // (int)를 앞에 선언해서 문자num3('5')라는 것을 정수형으로 캐스팅 시킴
			
			// 상수 : 항상 변하지 않는 값
			// ex) final double PI = 3.14;
			
			// 형변환 (캐스팅)
			// 1. 묵시적 형변환 (업캐스팅 : 값이 작은 범위에서 큰 범위로의 형변환 문자 -> 정수 -> 실수 올라가는형태, 형 변환 타입 생략가능)
			int num4 = num3;  // (int)를 안넣어도 문자형에서 정수형으로 형변환이 가능
			System.out.println(num4);
			
			// 2. 명시적 형변환 (다운캐스팅 : 값이 큰 범위에서 작은 범위로의 형변환 실수 -> 정수 -> 문자 내려가는형태, 형 변환 타입 생략 불가능)
			char num5 = (char)num4; // (char)를 이용하여 정수형에서 문자형으로 형변환
			System.out.println(num5);
			
			// 리터럴 정수 = int, 실수 = double
	}
}
