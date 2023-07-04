package ch11_문자열;

public class String04 {
	public static void main(String[] args) {
		String phone ="         010      -         9988.1916                         ";
		
		String replacePhone = phone
				.replaceAll("-", "/")
				.replaceAll(" ", "")
				.replaceAll("[.]", ""); // .replaceAll 데이터를 정제 할때 사용 .replaceAll() 안에 . 은 [.] 으로 나타 내야한다.
		
		System.out.println(replacePhone);
		
		String phone2 = phone.trim(); // .trim 앞 뒤 쪽으로 넣은 공백들을 제거해줌
		System.out.println(phone2);
		
		
	}
}
