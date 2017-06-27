/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt.exam02;

import java.util.Scanner;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author ijeongsu
 */
public class Device2Example {
	public static void main(String[] args) throws MqttException {
		Device device = new Device("device2");
		device.subscribe();
		
		Scanner scanner = new Scanner(System.in,"UTF-8");
		
		while(true){
			System.out.print("input message or q(quit)$");
			String text = scanner.nextLine();
			if(text.equals("q")) break;
			device.publish("device1", text);
		}
		
		device.close();
	}
}
