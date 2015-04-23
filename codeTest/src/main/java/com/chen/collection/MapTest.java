package com.chen.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapTest {
	public static void main(String[] argus) {
		Hashtable table = new Hashtable();
		try {
			table.put("test", null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hashtable value is not allow null");
		}
		
		try {
			table.put(null, "test");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hashtable key is not allow null");
		}
		
		table.put("test", "test");
		
		Map<String,String> map = new HashMap<String,String>();
		try {
			map.put(null, "test");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hashtable key is not allow null");
		}
		
		try {
			map.put("test", null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hashmap value is not allow null");
		}
		
		try {
			map.put(null, null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hashmap key value is not allow null");
		}
	}
}
