package org.warn.example.singletonreset;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.AfterClass;
import org.junit.Test;

public class SingletonResetTest {
	
private static ExecutorService service = Executors.newFixedThreadPool(3);
	
	@AfterClass
	public static void shutodwn() {
		service.shutdown();
	}
	
	@Test
	public void testSingletonReset() throws InterruptedException {
		
		EventProcessorFactory eventProcessorFactory = new EventProcessorFactory();
		
		EventProcessor eventProcessor1 = eventProcessorFactory.createEventProcessor("1");
		EventProcessor eventProcessor2 = eventProcessorFactory.createEventProcessor("2");
		EventProcessor eventProcessor3 = eventProcessorFactory.createEventProcessor("3");
		EventProcessor eventProcessor4 = eventProcessorFactory.createEventProcessor("4");
		
		service.execute( () -> {
			eventProcessor1.onEvents();
		});
		service.execute( () -> {
			eventProcessor2.onEvents();
			// call reset
			eventProcessor2.resetMqttClient();
		});
		service.execute( () -> {
			eventProcessor3.onEvents();
		});
		service.execute( () -> {
			eventProcessor4.onEvents();
		});
		
		service.execute( () -> {
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			eventProcessor1.onEvents();
		});
		service.execute( () -> {
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			eventProcessor2.onEvents();
		});
		service.execute( () -> {
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			eventProcessor3.onEvents();
		});
		service.execute( () -> {
			try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			eventProcessor4.onEvents();
		});
		
		Thread.sleep(5000);
	}

}
