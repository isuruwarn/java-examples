package org.warn.example.singletonreset;

import lombok.Setter;

public class BatchGateway {

	private String id;
	
	@Setter
	private MqttCloudGateway client;

	public BatchGateway( String id, MqttCloudGateway client) {
		this.id = "BG" + id;
		this.client = client;
	}

	public void send( String callerId ) {
		System.out.println( "BatchGateway - " + callerId + "-" + id + " - calling send on MqttCloudGateway=" + client.hashCode() );
		this.client.send( callerId + "-" + id );
	}

}
