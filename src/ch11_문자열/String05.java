package ch11_문자열;

public class String05 {
	public static void main(String[] args) {
		
		String name = " "; // 문자열을 다룰 때는 따로 처리를해야한다
		
		boolean flag = name.isBlank(); // .isBlank() 
		System.out.println(flag);
		
		boolean flag2 = name.isEmpty(); // .isEmpty() 
		System.out.println(flag2);
				
		
	}
}
