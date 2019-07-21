package org.warn.example.util;

import java.util.Random;

import org.junit.Test;

public class RandomTest {

	@Test
	public void testBoundInt() {
		Random r = new Random();
		int i = r.nextInt(16);
		System.out.println(i);
	}
}
