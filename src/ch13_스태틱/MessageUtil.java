package ch13_스태틱;

public class MessageUtil {
	
	// static : 생성을 할 필요 없다 , 공유한다. 정적이다. static 이 없으면 생성자를 만들어야 한다.
	
	
	public static String data;
	
	public void sendMail() {
		System.out.println("메일을 전송합니다.");
	}
	
	public static void sendFile() {
		System.out.println("파일을 전송합니다.");
	}
}
