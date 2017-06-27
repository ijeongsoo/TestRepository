/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam04.client;

import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;

/**
 *
 * @author ijeongsu
 */
public class CoapResource06Client {
	private CoapClient coapClient;
	private CoapObserveRelation coapObserveRelateion;
	
	public CoapResource06Client() {
		coapClient=new CoapClient();
	}
	
	public void observe(){
		coapClient.setURI("coap://10.10.10.73/resource06");
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
		CoapResource06Client client = new CoapResource06Client();
		client.observe();
		System.in.read();
		client.shutdown();
	}

}
