package org.warn.example.singletonreset;

public class MqttCloudGateway {

	private static MqttCloudGateway singleton = null;

	private MqttCloudGateway() {
		
	}

	public static synchronized MqttCloudGateway getInstance() {
		if (singleton == null) {
			System.out.println("MqttCloudGateway - instantiating..");
			singleton = new MqttCloudGateway();
		}
		return singleton;
	}

	public void send( String callerId ) {
		//System.out.println("MqttCloudGateway - invoked by - " + callerId );
	}

	// This could potentially break the singleton pattern since resetting this reference in a multi-threaded environment 
	// can lead to multiple MqttCloudGateway objects, which are referenced by different BatchGateway instances.
	public static void reset() {
		System.out.println("MqttCloudGateway - resetting singleton..");
		singleton = null;
	}

}