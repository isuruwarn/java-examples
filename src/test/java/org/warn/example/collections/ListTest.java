package org.warn.example.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

	@Test
	public void testFlatMapOfList() {
		List l1 = IntStream.of(1,2,3).boxed().collect(Collectors.toList());
		List l2 = IntStream.of(4,5,6).boxed().collect(Collectors.toList());
		List l3 = IntStream.of(7,8,9).boxed().collect(Collectors.toList());
		List l4 = IntStream.of(10,11,12).boxed().collect(Collectors.toList());
		List<List<Integer>> listofLists = Arrays.asList(l1, l2, l3, l4 );
		listofLists.stream().flatMap(Collection::stream).forEach(n -> System.out.println(n) );
	}

	@Test
	public void testArrayListSort() {
		List<List<Integer>> arr = new ArrayList<>(
				Arrays.asList(
						Arrays.asList( 0, 2 ),
						Arrays.asList( 1, 4 ),
						Arrays.asList( 4, 6 ),
						Arrays.asList( 0, 4 ),
						Arrays.asList( 7, 8 ),
						Arrays.asList( 9, 11 ),
						Arrays.asList( 3, 10 )
				)
		);
		Collections.sort(arr, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(0) - o2.get(0);
			}
		});
		System.out.println( arr );

		List<List<Integer>> expectedArr = new ArrayList<>(
				Arrays.asList(
						Arrays.asList( 0, 2 ),
						Arrays.asList( 0, 4 ),
						Arrays.asList( 1, 4 ),
						Arrays.asList( 3, 10 ),
						Arrays.asList( 4, 6 ),
						Arrays.asList( 7, 8 ),
						Arrays.asList( 9, 11 )

				)
		);

		assertEquals( expectedArr, arr );
	}
}
