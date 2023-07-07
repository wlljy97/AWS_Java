package test풀이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch10_배열.Customer;

public class MapList {
	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> customer1 = new HashMap<String, Object>();
		customer1.put("name", "홍길동");
	
		
		for (Map<String, Object> customer : customers){
			for(Map.Entry<String, Object> entry : customer.entrySet()) {
				System.out.println(entry);
			}
			
			
		}
	}
}
