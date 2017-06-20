/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt.exam01;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author ijeongsu
 */
public class MqttSubscriber {
	//field
	private MqttClient mqttClient;
	
	private MqttCallback mqttCallback = new MqttCallback() {
		@Override
		public void connectionLost(Throwable thrwbl) {
		}

		@Override
		public void messageArrived(String string, MqttMessage mm) throws Exception {
			String text = new String(mm.getPayload());
			System.out.println(text);
		}

		@Override
		public void deliveryComplete(IMqttDeliveryToken imdt) {
		}
	};
	
	
	//Constructor

	public MqttSubscriber() throws MqttException {
		//MQTT 클라이언트 생성
		mqttClient = new MqttClient("tcp://192.168.3.129:1883", MqttClient.generateClientId());
		//통신 결과에 따라 실행할 콜백 객체 생성 
		mqttClient.setCallback(mqttCallback);
		//MQTT 브로커와 연결하기 
		mqttClient.connect();
	}
	
	
	//Method
	public void subscribe() throws MqttException{
		//지정 토픽의 구독자로 신청하기  
		mqttClient.subscribe("/devices/device1/temperature");
	}
	
	public void shutdown() throws MqttException{
		//연결 끊기
		mqttClient.disconnect();
		//클라이언트 사용한 리소스를 해제 
		mqttClient.close();
	}
	
	public static void main(String[] args) throws Exception {
		MqttSubscriber subscriber = new MqttSubscriber();
		
		subscriber.subscribe();
		System.out.println("start subscriber");
		System.out.println("press any key to quit");
		System.in.read();
		
		subscriber.shutdown();
	}
}
