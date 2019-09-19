package org.warn.example.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.AfterClass;
import org.junit.Test;

public class CallableTaskTest {
	
	private static ExecutorService service = Executors.newFixedThreadPool(1);
	
	@AfterClass
	public static void shutodwn() {
		service.shutdown();
	}

	@Test
	public void testCallable1() throws InterruptedException, ExecutionException {
		
		System.out.println("Submitting callable task..");
		
		Future<String> future = service.submit( new CallableTask() );
		System.out.println("Callable task submitted..");
		
		String result = future.get();
		System.out.println("Callable task result - " + result);
		
		
	}
	
	@Test
	public void testCallable2() throws InterruptedException, ExecutionException {
		
		CallableTask callableTask = new CallableTask();
		
		System.out.println("Calling call method..");
		
		String result = callableTask.call();
		System.out.println("Callable task result - " + result);
	}
}
