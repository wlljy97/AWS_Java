package test풀이;

public class Casting {
	public static void main(String[] args) {
		
		Program[] programs = new Program[2];
		programs[0] = new Java();
		programs[1] = new C();
		
		for (int i = 0; i < programs.length; i++) {
			programs[i].develop();
			
			if(programs[i].getClass() == Java.class) {
				Java java =(Java) programs[i];
				java.garbageCollection();
			}else if(programs[i].getClass() == C.class) {
				C c = (C) programs[i];
				c.defineStructure();
			}
			
			
//			if (programs[i] instanceof Java){
//				Java java = (Java) programs[i]; 
//				System.out.println("메모리를 정리합니다.");
//				
//			}else if (programs[i] instanceof C) {
//				C c = (C) programs[i];
//				System.out.println("구조체를 정의합니다.");
//			}
			
		}
		
	}
}
