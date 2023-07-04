package ch22_익명클래스;
// 함수형 프로그래밍
public class LambdaTest {
	
	// 인터페이스 안의 딱 하나의 추상메소드 만 있어야 한다.
	public static void main(String[] args) {
		GrantedAuthorities authorities2 = new GrantedAuthorities() {
			
			@Override
			public String getAuthority() {
				System.out.println("권한 출력");
				return "ROLE_USER";
			}
		};
		
		// -> 화살표 함수
		
		GrantedAuthorities authorities = () -> {
			System.out.println("권한출력");
			return "ROLE_USER";
		};
		
		// GrantedAuthorities authorities = () -> "ROLE_USER"; 위의 식을 이렇게 나타낼수 있다.
		
		// 람다식은 자료형을 생략 할 수 있다.
		System.out.println(authorities.getAuthority());
	}
}
