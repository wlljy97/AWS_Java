package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch10_배열.Customer;

public class MapList {
	public static void main(String[] args) {
		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		
		System.out.println("name = 홍길동");
		System.out.println("rating = vip");
		System.out.println("age = 30");
		System.out.println("name = 김기영");
		System.out.println("rating = gold");
		System.out.println("age = 35");
		
		for (Map<String, Object> customer : customers){
		}
	}
}
