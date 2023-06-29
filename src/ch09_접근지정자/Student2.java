package ch09_접근지정자;

	public class Student2 {
		
		// private : 동일 클래스 내에서만
		private String name;
		private int age;
		
		// test() : 클래스 내에서만 사용한다.
		private void test() {
			System.out.println("테스트 메소드 호출");
		}
		
		
		// public : 접근제한 없음
		
		// Setter : 값을 세팅해준다
		public void setName(String name) {
			test();
			this.name = name;
		}
		public void setAge(int age) {
			test();
			this.age = age;
		}
		
		// Getter : 값을 가지고 온다.
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		
}
