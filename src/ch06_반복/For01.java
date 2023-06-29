package ch06_반복;

public class For01 {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6};
		
//		for (int i = 0, j = 0; i < 6; i++, j++) System.out.println(numbers[i]); 여러가지 변수를 반복
		
		// (초기문1 중간문2(반복할 횟수) 후처리3) 실행4  1->2->4->3->2->4->3->....->2->4
		for (int i = 0; i < 6; i++) {
			System.out.println(numbers[i]); 
			System.out.println("i : " + i);
		}
		
		
		
	}

}
