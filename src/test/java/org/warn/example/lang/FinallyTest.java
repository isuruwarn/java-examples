package org.warn.example.lang;

import org.junit.Test;

public class FinallyTest {
	
	@Test
	public void testFinallyDuringReturn() {
		try {
			return;
		} finally {
			System.out.println("Finally block 1");
		}
	}
	
	@Test(expected = NumberFormatException.class)
	public void testFinallyDuringException() {
		try {
			Integer.parseInt("abc");
		} finally {
			System.out.println("Finally block 2");
		}
	}
	
	
	
	@Test
	public void testFinallyDuringSystemExit() {
		try {
			//System.exit(0);
		} finally {
			// will NOT reach this line if System.exit is uncommented
			System.out.println("Finally block 3");
		}
	}


}
