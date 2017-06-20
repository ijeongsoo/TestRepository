/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam04.client;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class CoapResource05Client {
	private CoapClient coapClient;
	private CoapObserveRelation coapObserveRelateion;
	
	public CoapResource05Client() {
		coapClient=new CoapClient();
	}
	
	public void observe(){
		coapClient.setURI("coap://192.168.3.36/resource05");
		coapObserveRelateion = coapClient.observe(new CoapHandler() {
			@Override
			public void onLoad(CoapResponse cr) {
				String text = cr.getResponseText();
				System.out.println(text);
			}

			@Override
			public void onError() {
			}
		});
	}
	
	public void shutdown(){
		coapObserveRelateion.proactiveCancel();
		coapClient.shutdown();
		
	}
	
	public static void main(String[] args) throws IOException {
		CoapResource05Client client = new CoapResource05Client();
		client.observe();
		System.in.read();
		client.shutdown();
	}

}
