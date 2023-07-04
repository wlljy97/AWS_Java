package ch20_컬렉션;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapMain {
	public static void main(String[] args) {
		// map 키 벨류의 값을 동시에 저장할 수 있다. 
		// key 값은 정렬이 되어 있지않다.
		
		HashMap<String, String> strMap = new HashMap<>();
		strMap.put("username", "aaa");
		strMap.put("password", "1234");
		strMap.put("name", "김준일");
		
		System.out.println(strMap);
		System.out.println(strMap.get("username"));
		
		// Map 반복을 돌릴 때는 Entry 형을 선호한다.
		for(Entry<String, String> entry : strMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println("====================");
		
		for(String key : strMap.keySet()) {
			System.out.println(key);
			System.out.println(strMap.get(key));
		}
		
	}
}
