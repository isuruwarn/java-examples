package org.warn.example.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {

	@Test
	public void countTest1() {
		
		Map<String, AtomicLong> map = new HashMap<>();
		map.put("1", new AtomicLong(10));
		map.put("2", new AtomicLong(10));
		map.put("3", new AtomicLong(10));
		map.put("4", new AtomicLong(10));
		map.put("5", new AtomicLong(10));
		
		long count = map.values().stream().mapToLong( a -> a.get() ).sum();
		
		assertTrue( 50 == count );
	}
	
	
	@Test
	public void flatmapTest1() {
		
		List<List<String>> listOfLists = Arrays.asList(
				Arrays.asList( "Alice", "Bob", "Charlie" ),
				Arrays.asList( "John", "Mary" )
				);
		List<String> expectedFlatList = Arrays.asList( "Alice", "Bob", "Charlie", "John", "Mary" );
		
		assertEquals( expectedFlatList, listOfLists.stream()
										.flatMap( list -> list.stream() )
										.collect( Collectors.toList() ) 
								);
	}
	
	@Test
	public void flatmapTest2() throws IOException {
		
		Stream<String> lines = Files.lines( Paths.get("src\\main\\resources\\txt\\file.txt"), StandardCharsets.UTF_8);
		Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
		
		List<String> flatWordList = words.collect( Collectors.toList() );
		List<String> expectedFlatList = Arrays.asList( "The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog" );
		assertEquals( expectedFlatList, flatWordList );
		
		lines.close();
	}
}
