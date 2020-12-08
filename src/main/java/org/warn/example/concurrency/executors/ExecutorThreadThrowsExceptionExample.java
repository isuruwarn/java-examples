package org.warn.example.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorThreadThrowsExceptionExample {

	public static void main(String args []) {
		
		AtomicInteger i = new AtomicInteger();
		//ExecutorService service = Executors.newSingleThreadExecutor(); // does not seem to recover once exception is thrown, but program does not terminate either.
		ExecutorService service = Executors.newScheduledThreadPool(1); // same as above
		service.submit( () -> {
			while (true) {
				//try {
					i.getAndIncrement();
					System.out.println("doing some work..." + i.get());
					Thread.sleep(2000);
					if( i.get() == 2 ) {
						throw new RuntimeException("Something bad happened!");
					}
					System.out.println("doing some more work..." + i.get());
				//} catch(Exception e) {
				//	e.printStackTrace();
				//}
			}
		});
	}
}
