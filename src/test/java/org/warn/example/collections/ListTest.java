package org.warn.example.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void listEqualsCheck1() {
		List<String> arr1 = new ArrayList<String>( Arrays.asList( "One", "Two", "Three" ) );
		List<String> arr2 = Arrays.asList( "One", "Two", "Three" );
		assertEquals( arr1, arr2 );
	}
	
	@Test
	public void listEqualsCheck2() {
		List<String> arr1 = new ArrayList<String>( Arrays.asList( "One", "Two", "Three" ) );
		List<String> arr2 = Arrays.asList( "Two", "One", "Three" );
		assertNotEquals( arr1, arr2 );
	}
	
	@Test
	public void testArraysToList1() {
		List<Integer> list = Arrays.asList( 1, 1, 0, 1 );
		assertTrue( list.contains(0) );
	}
	
	@SuppressWarnings({ "null", "unused" })
	@Test(expected=NullPointerException.class)
	public void testNullArraysListInLoop() {
		ArrayList<String> arr = null;
		for(String s: arr) {
			//
		}
	}
}
