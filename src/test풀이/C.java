package test풀이;

import lombok.ToString;

@ToString(callSuper = true)
public class C extends Program{

	@Override
	public void develop() {
		System.out.println("C 프로그램을 개발합니다.");
	}
	public void defineStructure() {
		System.out.println("구조체를 정의합니다.");
	}
	
}
