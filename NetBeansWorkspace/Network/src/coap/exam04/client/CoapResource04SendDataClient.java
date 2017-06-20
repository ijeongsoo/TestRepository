/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam04.client;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class CoapResource04SendDataClient {
	private CoapClient coapClient;
	
	public CoapResource04SendDataClient() {
		coapClient=new CoapClient();
	}
	
	public void post(){
		coapClient.setURI("coap://192.168.3.36/resource04");
		Random random = new Random();
		while(true){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("value", random.nextInt(50));
			String json = jsonObject.toString();
			coapClient.post(json,MediaTypeRegistry.APPLICATION_JSON);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				Logger.getLogger(CoapResource04SendDataClient.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public void shutdown(){
		coapClient.shutdown();
	}
	
	public static void main(String[] args) {
		CoapResource04SendDataClient client = new CoapResource04SendDataClient();
		client.post();
		client.shutdown();
	}

}
