package org.example;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Company01 {
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("companyId", "100");
		jsonObject.addProperty("companyName", "Apple");
		jsonObject.addProperty("address", "Apple Computer Inc. 1 infinite Loop");
		jsonObject.addProperty("city", "Cupertino");
		jsonObject.addProperty("state", "CA");
		jsonObject.addProperty("zipCode", "95014");
		
		System.out.println(jsonObject);
		
	}
}
