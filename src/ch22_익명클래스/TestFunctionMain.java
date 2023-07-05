package ch22_익명클래스;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestFunctionMain {
	public static void main(String[] args) {
//		TestFunction1 function1 = () -> {
//			System.out.println("매개변수 x, 리턴 x");
//		}; 
		
		// 명령문이 하나인 경우에는 중괄호{} 를 생략할 수 있다.
		// 생성과 메소드 정의가 동시에 일어난다.
		TestFunction1 function1 = () -> System.out.println("매개변수 x , 리턴 x");
		
		function1.test(); // 주소 참조. test 호출
		
//		TestFunction2 function2 = (int num) -> {
//			System.out.println("매개변수 1개, 리턴x");
//			System.out.println("num" + num);
//		};
		
		// 매개변수는 타입을 생략 할 수 있다. 
		// 그리고 (↑비교) 매개변수가 하나인 경우에는 괄호()도 생략 가능하다.
		
		TestFunction2 function2 = num -> {
			System.out.println("매개변수 1개, 리턴 x");
			System.out.println("num" + num);
		};
		
		function2.test(100);
		
		// 매개변수가 없거나 2개 이상일 경우에는 매개변수의 괄호를 생략할 수 없다.
		TestFunction3 function3 = (age, name) -> {
			System.out.println("매개변수 2개, 리턴 x");
			System.out.println("나이 : " + age);
			System.out.println("이름 : " + name);
		};
		 
		function3.test(30, "김준일");
		
//		TestFunction4 function4 = (age, name) -> {
//			System.out.println("매개변수 2개, 리턴 o");
//			return "나이 : " + age + ", 이름 : " + name;
//		};
		
		// 명령이 한 줄인 경우 중괄호를 생략 할 수 있으며 중괄호를 생략한 경우 
		// 즉시 리턴값이 된다. (↑비교)
		TestFunction4 function4 = (age, name) ->  "나이 : " + age + ", 이름 : " + name;
		
		String result1 = function4.test(30, "김준일");
		System.out.println(result1);
		
		// Runnable : 실행 때 쓴다. 매개변수x, 리턴x
		Runnable runnable = () -> {
			System.out.println("매개변수 x, 리턴 x");
		}; // {}; 생략가능
		
		runnable.run();
		
		// Consumer 매개변수 o, 리턴x
		// (↓밑에는) 매개변수의 타입이 String이 되어야 한다.
		Consumer<String> consumerStr = name -> {
			System.out.println(name);
		};
		
		consumerStr.accept("김준일");
		
		// BiConsumer
		BiConsumer<String, Integer> biConsumer = (name, age) -> {
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
		};
		
		biConsumer.accept("김준일", 30);
		
		// Supplier :
		// 리턴이 생략이 되었음
		Supplier<Integer> supplier = () -> 100;
		System.out.println(supplier.get());
		
		// Function 매개변수 o, 리턴 o
		Function<Integer, String> function = year -> "생일 : " + year;
		System.out.println(function.apply(1994));
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		
		System.out.println(numbers);
		numbers.removeIf(num -> num % 2 == 0);
		
		// predicate : 매개변수도 있고, 반환값도 존재하지만, Function과 달리 Boolean 값을 반환한다
		System.out.println(numbers);
		
		// 향상된 for문을 함수값으로? 나타낸 것이 forEach문
		numbers.forEach(num -> System.out.println("출력 : " + num)); 
		
	}
}
