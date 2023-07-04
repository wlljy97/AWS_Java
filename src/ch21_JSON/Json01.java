package ch21_JSON;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Json01 {
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("productCode", "P2023704");
		dataMap.put("productName", "아이폰15");
		
		System.out.println(dataMap);
		
		// json 처음 부터 끝까지 문자열,
		// 객체형태를 문자열로 변환한다
		// 객체를 json으로 json을 객체로 변환 할 줄 알아야 한다.
		// json을 쓰기 위해서는 gson을 써야한다.
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("productCode", "P2023704");
		jsonObject.addProperty("productName", "아이폰");
		
		System.out.println(jsonObject);
		
		// Map을 json 형태로 변환 한것
		System.out.println(gson.toJson(dataMap));
		
		// json을 Map으로 변환 한것 
		Map<String, Object> jsonMap = gson.fromJson(jsonObject, Map.class);
		System.out.println(jsonMap.get("productCode"));
		
	}
}
