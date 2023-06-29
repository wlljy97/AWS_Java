package ch08_생성자;

public class Student {
		
		// (↓)멤버 변수 or 필드
		final String name;
		int age;
		String address;
		
//		Student() {
//			name = ""; // final이 오면 초기화를 꼭 시켜 줘야한다.!  기본생성자를 없애야 한다.
//			System.out.println("NoArgsconstructor"); // 기본 생성자
//			System.out.println("학생 한명을 생성합니다.");
//		}
		
		Student(String name, int age, String address) {
			System.out.println("AllArgsconstructor"); // 전체 생성자
			this.name = name; // this. : 자기자신 이라는 개념, new를 찍는 순간 this. 자체가 자기주소가 된다. (자기자신주소.변수 = )
			this.age = age;
			this.address = address; 
		}
		
//		NoArgsconstructor 와 RequiredArgsConstructor 같이 나올 수 없다 둘중 한가지만 나와야 한다.
		
		Student(String name){
			System.out.println("RequiredArgsConstructor"); // 필수 생성자
			this.name = name;
//			this.age = age;
//			this.address = address;
			
			
		}
		
}
