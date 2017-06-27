/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt.exam02;

import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 *
 * @author ijeongsu
 */
public class DistributorExample {
	public static void main(String[] args) throws MqttException, IOException {
		Distributor distributor = new Distributor();
		
		distributor.subscribe();
		System.out.print("press any key to quit");
		System.in.read();
		
		distributor.close();
	}
}
