package org.warn.example.singletonreset;

public class EventProcessorFactory {

	public EventProcessorFactory() {
		
	}

	public EventProcessor createEventProcessor( String id ) {
		
		final MqttCloudGateway mqttCloudGateway = getMqttCloudGateway();
		final BatchGateway batchWriteMqttGateway = new BatchGateway( id, mqttCloudGateway );
		
		System.out.println("EventProcessorFactory - creating EventProcessor" + id + " with MqttCloudGateway=" + mqttCloudGateway.hashCode() );
		return new EventProcessor( id, batchWriteMqttGateway );
	}
	
	public static MqttCloudGateway getMqttCloudGateway() {
		return MqttCloudGateway.getInstance();
	}
}
