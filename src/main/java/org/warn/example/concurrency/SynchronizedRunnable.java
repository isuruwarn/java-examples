package org.warn.example.concurrency;

import java.util.concurrent.CountDownLatch;

public class SynchronizedRunnable implements Runnable {

	private Synchronized sync;
	private String name;
	private CountDownLatch countDown;
	
	// used for static synchronized function test
	public SynchronizedRunnable(String name, CountDownLatch countDown) {
		this.name = name;
		this.countDown = countDown;
	}
	
	// used for instance synchronized function test
	public SynchronizedRunnable( Synchronized sync, String name, CountDownLatch countDown ) {
		this.sync = sync;
		this.name = name;
		this.countDown = countDown;
	}
	
	public void run() {
		
		System.out.println("Started thread - " + this.name);
		
		if( sync == null ) {
			// check static synchronized function
			Synchronized.staticSyncMethod(this.name);
			
		} else {
			// check instance synchronized function
			this.sync.instanceSyncMethod(this.name);
		}
		
		this.countDown.countDown();
		System.out.println("Completed thread - " + this.name);
	}

}
