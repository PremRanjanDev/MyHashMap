package com.demo;

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

		for (Integer i = 0; i < 2000; i++) {
			map.put(i, i);
		}

		System.out.println(map);
		System.out.println("size: " + map.getSize());

		System.out.println(null + " : " + map.get(null));
		System.out.println("ABC" + " : " + map.get("ABC"));
		System.out.println(1888 + " : " + map.get(1888));

		map.remove(0);
		map.remove(100);
		map.remove(null);
		map.remove("123");

		System.out.println(map);

		System.out.println("size: " + map.getSize());
	}

}
