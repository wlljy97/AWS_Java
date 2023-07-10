package ch24_쓰레드;

public class 분신 extends Thread {
	private static int number;
	private int num; // 멤버 변수 (각각의 변수)
	
	public 분신() {
		number += 1;
		num = number;
	}
	
	@Override // 상속 받아서 재정의
	public void run() {
		System.out.println(num + "분신 실행");
		while(true) {
			System.out.println(num + "분신 반복"); 
			try {
				Thread.sleep(3000); // 잠시 3초 동안 잠듬(쉼) 3초마다 동작
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
