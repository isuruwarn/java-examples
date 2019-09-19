package org.warn.example.singletonreset;

public class SingletonObject {
	
	private static SingletonObject instance;
	
	private SingletonObject() {
		
	}
	
	public static synchronized SingletonObject getInstance() {
		if( instance == null ) {
			instance = new SingletonObject();
		}
		return instance;
	}

	public void doSomething( String callerId ) {
		System.out.println("Method invoked by - " + callerId );
	}
	
	// NOT a good idea
	public static void reset() {
		instance = null;
	}
}
