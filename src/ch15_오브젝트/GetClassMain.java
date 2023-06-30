package ch15_오브젝트;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GetClassMain {
	
	public static void main(String[] args) {
		KoreaStudent koreaStudent = new KoreaStudent("20230001", "김채원");
		
		// classclass
		Method[] methods = koreaStudent.getClass().getDeclaredMethods();
		for(int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].getName());
			System.out.println(methods[i].getReturnType());
		}
		
		System.out.println();
		
		Field[] fields = koreaStudent.getClass().getDeclaredFields();
		for(int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getName());
		}
		
		System.out.println();
		// class type 비교
		System.out.println(KoreaStudent.class == koreaStudent.getClass()); // <- 자기 자신의 클래스로 비교 해야함
		// ↑↓ 같은 것
		System.out.println(koreaStudent instanceof Object);
		
		System.out.println(koreaStudent.getClass().getSimpleName());
		System.out.println(koreaStudent.getClass().getName());
		
		
	}
}
