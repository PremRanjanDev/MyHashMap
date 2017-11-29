package com.mymap.demo;

import com.mymap.MyHashMap;

public class Test {

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();
		
		map.put("ABC", null);
		map.put("ABC", "123");
		map.put(null, "Prem");
		map.put(null, "Ranjan");
		map.put("123", null);
		map.put(123, null);
		
		System.out.println(map);
	}

}
