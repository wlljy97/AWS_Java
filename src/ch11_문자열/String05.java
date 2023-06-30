package ch11_문자열;

public class String05 {
	public static void main(String[] args) {
		
		String name = " "; // 문자열을 다룰 때는 따로 처리를해야한다
		
		boolean flag = name.isBlank(); // .isBlank() : 문자열이 비어 있거나, 빈 공백으로만 이루어져 있으면, true를 리턴합니다.
		System.out.println(flag);
		
		boolean flag2 = name.isEmpty(); // .isEmpty() : 문자열의 길이가 0인 경우에, true를 리턴합니다.
		System.out.println(flag2);
				
		
	}
}
