package org.warn.example.concurrency;

public class Synchronized {

	public static synchronized void staticSyncMethod(String msg) {
		System.out.println("START static sync method.." + msg);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("END static sync method.." + msg);
	}
	
	public synchronized void instanceSyncMethod(String msg) {
		System.out.println("START instance sync method.. " + msg);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("END instance sync method.. " + msg);
	}
	
}
