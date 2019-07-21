package org.warn.example.operations;

import org.junit.Test;

public class OperationsTest {
	
	@Test
	public void testLeftShift1() {
		System.out.println( 1 << 1000 );
	}
	
	@Test
	public void testLeftShift2() {
		System.out.println( 1000 << 1 );
	}

}
