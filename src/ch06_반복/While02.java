package ch06_반복;

public class While02 {
	public static void main(String[] args) {
		
		// 중요
		int i = 0;
		
		while(i < 10) {
			if(i % 2 == 0) {
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
		
	}

}
