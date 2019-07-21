package org.warn.example.lang;

import org.junit.Test;

public class ClassPathTest {
	
	@Test
	public void testAbsoluteClasspath() {
		String absClassPath = ClassPathTest.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		System.out.println(absClassPath);
	}

}
