package ch06_반복;

public class For03 {

	public static void main(String[] args) {
		
		// 반복문 안의 반복문 // i 부터 시작하는이유는 index 첫자를 따서 i로 시작
//		for (int i = 0; i < 5; i++) { // 0 1 2 3 4
//			
//			for (int j = 0; j < i + 1; j++) { // 1 2 3 4 5
//				System.out.print("*");
//				
//			}
//			System.out.println();
//		}
		
//		for (int i = 0; i < 5; i++) {
//			
//			for (int j = 0; j < 5 - i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		for(int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - 1 - i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("==============================================");
		
		for (int i = 0; i < 10; i++) {
			System.out.println("2 * "+ i + " = " + 2 * i);
		}
		System.out.println("==============================================");
		
		for (int i = 2; i < 3; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i +  " * " + j + " = " + i * j);
			}
		}
		
		System.out.println("==============================================");
		
		for(int i = 2; i < 10; i++) {
			System.out.println("====" + i + "단====");
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			
		}
		
	}
}
