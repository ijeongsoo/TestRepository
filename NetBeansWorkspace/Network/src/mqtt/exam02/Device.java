/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt.exam02;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class Device {
	//field 
	private String url="tcp://192.168.3.129:1883";
	private String myClientID="device1";
	private String topicRequest="/devices/"+myClientID+"/request";
	private String topicResponse="/devices/"+myClientID+"/response";
	
	private int qos=1;
	
	private MqttClient mqttClient;
	
	private MqttCallback callback = new MqttCallback() {
		@Override
		public void connectionLost(Throwable thrwbl) {
			try {
				close();
			} catch (MqttException ex) {ex.printStackTrace();}
		}

		@Override
		public void messageArrived(String string, MqttMessage mm) throws Exception {
			System.out.println("Message ->"+mm.toString());
			System.out.print("input message or q(quit)$ ");
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken imdt) {
		}
	};
	
	//constructor
	
	
	//method

	public Device(String myClientID) throws MqttException {
		this.myClientID=myClientID;
		topicRequest="/devices/"+myClientID+"/request";
		topicResponse="/devices/"+myClientID+"/response";
		
		
		mqttClient= new MqttClient(url, myClientID);
		mqttClient.setCallback(callback);
		mqttClient.connect();
	}
	
	public void subscribe() throws MqttException{
		mqttClient.subscribe(topicResponse);
	} 
	
	public void publish(String targetClientID, String text) throws MqttException{
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("from", myClientID);
		jsonObject.put("to", targetClientID);
		jsonObject.put("text", text);
		String json = jsonObject.toString();
		MqttMessage mqttMessage = new MqttMessage(json.getBytes());
		mqttMessage.setQos(qos);
		mqttClient.publish(topicRequest, mqttMessage);
	}
	
	public void close() throws MqttException{
		if(mqttClient != null){
			mqttClient.disconnect();
			mqttClient.close();
			mqttClient=null;
		}
	}
	
}
