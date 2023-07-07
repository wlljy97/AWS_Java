package test풀이;

import lombok.ToString;

@ToString(callSuper = true)
public class Java extends Program{
	
	@Override
	public void develop() {
		System.out.println("자바 프로그램을 개발합니다.");
	}
	
	public void garbageCollection() {
		System.out.println("메모리를 정리합니다.");
	}

}
