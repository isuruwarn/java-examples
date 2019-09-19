package org.warn.example.singletonreset;

public class EventProcessor {

	private String id;
	private BatchGateway batchGateway;
	
	EventProcessor( String id, BatchGateway batchGateway) {
		this.id = "EP" + id;
		this.batchGateway = batchGateway;
	}

	public void onEvents() {
		batchGateway.send( this.id );
	}

	public void resetMqttClient() {
		MqttCloudGateway.reset();
		this.batchGateway.setClient( EventProcessorFactory.getMqttCloudGateway() );
		System.out.println("EventProcessor - " + this.id +" - new MqttCloudGateway=" + MqttCloudGateway.getInstance().hashCode() );
	}
	
}