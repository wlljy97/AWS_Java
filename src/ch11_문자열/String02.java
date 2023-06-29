package ch11_문자열;

public class String02 {
	
	public static void main(String[] args) {
		String phone = "010-9988-1916";
		
		int index = phone.indexOf("-"); // indexOf는 해당문자의 위치를 알려준다.
		int lastIndexOf = phone.lastIndexOf("-");
		
		System.out.println(index);
		System.out.println(lastIndexOf);
		
		String midNumber = phone.substring(index + 1, lastIndexOf);
		
		System.out.println(midNumber);
		
		boolean findFlag = phone.contains("010");
		System.out.println(findFlag);
		
		
	}
}
