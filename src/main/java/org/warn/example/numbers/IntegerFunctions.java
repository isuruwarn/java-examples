package org.warn.example.numbers;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerFunctions {
	
	public void increment(Integer i) {
		i++;
	}
	
	public void increment(AtomicInteger i) {
		i.incrementAndGet();
	}

}
