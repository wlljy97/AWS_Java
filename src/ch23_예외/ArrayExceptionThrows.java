package ch23_예외;

public class ArrayExceptionThrows {
	
	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, 2, 3, 4, 5 };
		int a = 10;
		
		try {
			printArray(nums);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("프로그램 정상 종료");
		
	}
	
	public static void printArray(Integer[] numArray) throws Exception { 
		// throws Exception 강제로 달아서 예외처리를 확인한다, 예외를 강제성을 부여한다, 예외를 미룬다.
		if(true) {
			throw new RuntimeException("내가 강제로 생성한 예외"); // 예외를 생성함. 
		}
		for (int i = 0; i < numArray.length + 1; i++) {
				System.out.println(numArray[i]);
			}
		
		
	}
}

