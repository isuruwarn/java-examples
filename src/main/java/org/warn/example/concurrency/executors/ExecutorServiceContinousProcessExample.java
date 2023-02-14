package com.sap.gcs.mcco.core.utils;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceContinousProcessExample {

	private static Random r = new Random();

	public static void main(String args []) throws ExecutionException, InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();

		Future future = service.submit(() -> {
			while (true) {
				try {
					Integer result = doWork();
					System.out.println(result);
				} catch (Exception e) { // if we don't have this catch block, the program will exit the loop and terminate
					e.printStackTrace();
				}
			}
		});
		future.get(); // if we don't block and wait for completion, the program will terminate

		//service.shutdownNow(); not needed since we are running an endless loop
	}

	public static Integer doWork() {
		Integer i = r.nextInt();
		if(i<0)
			throw new RuntimeException("Error");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return i;
	}
}
