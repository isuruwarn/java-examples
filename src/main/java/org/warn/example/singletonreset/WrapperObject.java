package org.warn.example.singletonreset;

import lombok.Setter;

public class WrapperObject {
	
	private String id;
	
	@Setter
	private SingletonObject singleton;
	
	public WrapperObject( String id, SingletonObject singleton ) {
		this.id = id;
		this.singleton = singleton;
	}
	
	public void doSomething() {
		this.singleton.doSomething(id);
	}
	
	public void resetSingleton() {
		this.singleton = null;
	}

}
