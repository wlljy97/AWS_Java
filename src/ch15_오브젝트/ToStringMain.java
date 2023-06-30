package ch15_오브젝트;

public class ToStringMain {
	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "김영훈");
		
		System.out.println(koreaStudent.toString()); // toString 메소드는 생략가능
		
		// 변수에다가 String 을 쓰고 싶으면 toString을 쓴다
		String str = koreaStudent.toString();
//		String str2 = koreaStudent;
		
	}
}
