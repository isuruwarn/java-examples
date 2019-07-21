package org.warn.example.concurrency;

import java.util.concurrent.CountDownLatch;

import org.junit.Before;
import org.junit.Test;
import org.warn.example.concurrency.Synchronized;
import org.warn.example.concurrency.SynchronizedRunnable;

public class SynchronizedTest {
	
	private static final String THREAD_ONE = "1";
	private static final String THREAD_TWO = "2";
	
	private CountDownLatch countDown;
	private Synchronized sync = new Synchronized();
	
	@Before
	public void setup() {
		countDown = new CountDownLatch(2);
	}
	
	@Test
	public void testInstanceSynchronizedMethod() throws InterruptedException {
		
		System.out.println("Running instance synchronized method test..");
		
		SynchronizedRunnable r1 = new SynchronizedRunnable(sync, THREAD_ONE, countDown);
		SynchronizedRunnable r2 = new SynchronizedRunnable(sync, THREAD_TWO, countDown);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		countDown.await();
	}
	
	@Test
	public void testStaticSynchronizedMethod() throws InterruptedException {
		
		System.out.println("Running static synchronized method test..");
		
		SynchronizedRunnable r1 = new SynchronizedRunnable(THREAD_ONE, countDown);
		SynchronizedRunnable r2 = new SynchronizedRunnable(THREAD_TWO, countDown);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		countDown.await();
	}

}
