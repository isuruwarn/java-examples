package org.warn.example.concurrency;

/**
 * 
 * https://www.baeldung.com/java-volatile
 *
 */
public class VolatileExample {

	private static int number;
	private static boolean ready;

	public static void main(String[] args) throws InterruptedException {
		new Reader().start();
		number = 42;
		ready = true;
	}

	private static class Reader extends Thread {
		@Override
		public void run() {
			while (!ready) {
				Thread.yield();
			}

			System.out.println(number);
		}
	}

}
