package org.warn.example.datatypes;

import org.junit.Test;

public class ByteTest {

	@Test(expected=NumberFormatException.class)
	public void testRange1() {
		String s = "128";
		Byte.valueOf(s);
	}
}
