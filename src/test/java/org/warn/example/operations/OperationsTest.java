package org.warn.example.operations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {
	
	@Test
	public void testLeftShift1() {
		System.out.println( 1 << 1000 );
	}
	
	@Test
	public void testLeftShift2() {
		System.out.println( 1000 << 1 );
	}

	@Test
	public void testModulusOperations() {
		assertEquals( 7, 7 % 8 );
		assertEquals( 1, 8 % 7 );
		assertEquals( -7, -7 % 8 );
		assertEquals( -1, -8 % 7 );
		assertEquals( 0, -8 % 8 );
	}
}
