package ch24_쓰레드;

public class ThreadTestMain {
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(()-> {
			System.out.println("스레드 이름 : " + Thread.currentThread().getName());
			
			for (int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
				try {
					Thread.sleep(2000); // sleep도 예외 처리를 해야한다. 몇 초마다 실행하게 해준다
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}, "1번 스레드"); 
		
//		Thread thread2 = new Thread(()->System.out.println("2번 스레드 실행")); // 람다식으로 실행
		
		Thread thread2 = new Thread(()->{
			System.out.println("스레드 이름 : " + Thread.currentThread().getName());
			
			for(int i = 0; i < 50; i++) {
				System.out.print(Thread.currentThread().getName() + ": ");
				System.out.println(i);
			}
			
		}, "2번 스레드");
		
		Thread thread3 = new Thread(new ThreadTest(), "3번 스레드"); // implements를 사용해서 실행
		
		Thread thread4 = new Thread(new Runnable() { // 익명 생성해서 실행
			
			@Override
			public void run() {
				System.out.println("스레드 이름 : " + Thread.currentThread().getName());
				System.out.println("4번 스레드 실행");
			}
		}, "4번 스레드");
		
		thread1.start();
//		try {
//			thread1.join(); //       join을 thread 1번 상태가 끝날때 까지 다른 thread가 돌지 않는다.
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		thread2.start();
//		thread3.start();
//		thread4.start();
		
		// thread 순서대로 동작하지 않는다. 동시에 실행이 된다.
	}
}
