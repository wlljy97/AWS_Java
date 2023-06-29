package practice;

import java.util.Scanner;

public class Pr {
	public static void main(String[] args) {
				
		Scanner scanner = new Scanner(System.in);
		System.out.print("a : ");
		int a = scanner.nextInt();
		System.out.print("b : ");
		int b = scanner.nextInt();
		
		System.out.println("값은 : " + a * b);
				
		
//		Product p = new computer(); 업캐스팅
//		
//		Computer c = (Computer) p; 다운 캐스팅
//		
//		Computer c2 = (Computer) new Product; 은 형태가 달라서 되지않는다. 문법상 오류
		
		
		
	}
}
