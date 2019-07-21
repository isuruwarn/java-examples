package org.warn.example.datatypes;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.warn.example.numbers.IntegerFunctions;

public class IntegerTest {

	private IntegerFunctions func = new IntegerFunctions();
	
	@Test
	public void testIncrementIntegerObjectWithoutAssigning() {
		Integer i = new Integer(0);
		System.out.println(i);
		func.increment(i);
		System.out.println(i);
	}
	
	@Test
	public void testIncrementWithAtomicIntegerWithoutAssigning() {
		AtomicInteger ai = new AtomicInteger(0);
		System.out.println(ai);
		func.increment(ai);
		System.out.println(ai);
	}
	
	@Test
	public void testGetAndIncrement() {
		int i = 1;
		int j = i++;
		System.out.println("GetAndIncrement - " + i + " " + j);
	}
	
	@Test
	public void testIncrementAndGet() {
		int i = 1;
		int j = ++i;
		System.out.println("IncrementAndGet - " + i + " " + j);
	}
	
	@Test
	public void testEquals() {
		
		Integer int1 = new Integer(704);
		Integer int2 = new Integer(704);
		
		assertFalse( int1 == int2 );
		
		assertEquals( int1, int2 );
	}

}
