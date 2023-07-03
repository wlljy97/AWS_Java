package ch04_입력;

import java.util.Scanner;

public class Input02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// next는 스페이스바, 엔터를 무시함
		// nextLine은 스페이스바, 엔터를 무시하지 않음
		// 엔터는 버퍼의 마지막
		// nextLine를 제외한 next류는 비슷함
		
		/*
		 * 이름(name) :
		 * 나이(age) :
		 * 연락처(phone) :
		 * 주소(address) :
		 * 성별(gender) :
		 * 
		 * 고객님의 이름은 ㅇㅇㅇ이고 나이는 ㅇㅇㅇ세입니다.
		 * 연락처는 010-0000-0000이며 주소는 부산 동래구 사직동 입니다.
		 * 성별은 남입니다.
		 * 
		 */
		
		// 초기화 값
		String name = "";
		int age = 0;
		String phone = "";
		String address = "";
		String gender = "";
		
		System.out.print("이름 : ");
		name = scanner.next();
		
		System.out.print("나이 : ");
		age = scanner.nextInt(); 
		
		System.out.print("연락처 : ");
		phone = scanner.next(); // 이 때 입력 후 뒤에 버퍼에 엔터 자리가 남아있음
		scanner.nextLine(); // <- scanner.nextLine(); 이자리에 넣어준 이유 : 버퍼에 남아있는 엔터를 없애기 위해 넣어주었다
							// 넣어 주지 않으면 다음 nextLine 에서 남은 엔터를 가져가서 바로 다음 입력으로 넘어감
		
		
		System.out.print("주소 : ");
		address = scanner.nextLine();
		
		System.out.print("성별 : ");
		gender = scanner.next();
		
		System.out.println("고객님의 이름은" + name + "이고 나이는" + age +"세 입니다.");
		System.out.println("연락처는" + phone + "이며 주소는" + address + "입니다.");
		System.out.println("성별은" + gender + "입니다."); 
	}

}
