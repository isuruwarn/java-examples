package org.warn.example.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.junit.Test;

public class ConcurrentMapTest {
	
	@Test(expected=NullPointerException.class)
	public void testNullKey() {
		ConcurrentMap<String, String> map = new ConcurrentHashMap<String, String>();
		String key = null;
		map.get(key);
	}

}
