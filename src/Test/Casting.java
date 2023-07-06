package Test;

public class Casting {
	public static void main(String[] args) {
		
		Program[] programs = new Program[2];
		programs[0] = new Java();
		programs[1] = new C();
		
		for (int i = 0; i < programs.length; i++) {
			programs[i].develop();
			
			if (programs[i] instanceof Java){
				Java java = (Java) programs[i]; 
				System.out.println("메모리를 정리합니다.");
				
			}else if (programs[i] instanceof C) {
				C c = (C) programs[i];
				System.out.println("구조체를 정의합니다.");
			}
			
		}
		
	}
}
