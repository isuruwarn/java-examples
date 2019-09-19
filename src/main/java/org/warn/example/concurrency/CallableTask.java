package org.warn.example.concurrency;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

	@Override
	public String call() throws InterruptedException {
		System.out.println("Executing callable task..");
		Thread.sleep(5000);
		return "Hello";
	}

}
