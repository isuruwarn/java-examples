package org.warn.example.concurrency.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html
 *
 */
public class BlockingQueueExample {

	static class Producer implements Runnable {
		private final BlockingQueue queue;
		private final String name;
		
		Producer(String name, BlockingQueue q) {
			this.name = name;
			queue = q;
		}

		public void run() {
			try {
				while (true) {
					Object obj = produce();
					queue.put(obj);
					long l = Long.parseLong( obj.toString() );
					Thread.sleep(l*1000);
					
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		Object produce() {
			long r = Math.round(Math.random() * 10);
			System.out.println(name + " - " + r);
			return r;
		}
	}

	static class Consumer implements Runnable {
		private final BlockingQueue queue;
		private final String name;
		
		Consumer(String name, BlockingQueue q) {
			this.name = name;
			queue = q;
		}

		public void run() {
			try {
				while (true) {
					consume(queue.take());
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		void consume(Object x) {
			System.out.println( name + " - " + x.toString());
		}
	}

	public static void main(String[] args) {
		
		BlockingQueue q = new LinkedBlockingQueue();
		Producer p = new Producer("Producer1", q);
		Consumer c1 = new Consumer("Consumer1", q);
		Consumer c2 = new Consumer("Consumer2", q);
		Consumer c3 = new Consumer("Consumer3", q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
	}

}
