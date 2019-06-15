package com.generic.main;

import com.generic.cache.CacheHelper;

public class App {

	public static void main (String args[]) {
		
		CacheHelper<String, String> cache = new CacheHelper<String, String>();
		cache.save("first", "test");
		
		System.out.println(cache.show("first"));
		
		cache.save("2", "test1");
		cache.save("3", "test3");
		
		
		System.out.println(cache.list());
		
		System.out.println(cache.update("2", "updated"));
		
		System.out.println(cache.list());
		
		System.out.println(cache.delete("2"));
		
		System.out.println(cache.list());
		cache.shutdown();
	}
}
