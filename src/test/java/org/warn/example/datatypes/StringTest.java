package org.warn.example.datatypes;

import org.junit.Test;

public class StringTest {

	@Test
	public void test1() {
		StringBuilder sb = new StringBuilder("abcd aef ghiaj");
		while( sb.toString().contains("a") ) {
			sb.deleteCharAt(  sb.toString().indexOf('a') );
			System.out.println(sb.toString());
		}
	}
	
	@Test
	public void test2() {
		int i = 0;
		String s1 = "" + ++i;
		System.out.println(i + " " + s1);
		String s2 = ""+ i++;
		System.out.println(i + " " + s2);
	}
}
