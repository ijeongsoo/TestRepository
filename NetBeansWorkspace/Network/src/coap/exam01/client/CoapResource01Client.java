/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam01.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;

/**
 *
 * @author ijeongsu
 */
public class CoapResource01Client {
	//filed
	private CoapClient coapClient;
	//constructor
	public CoapResource01Client(){
		coapClient= new CoapClient();
	}
	//method
	
	public String get(){
		coapClient.setURI("coap://192.168.3.36/resource01");
		CoapResponse response=coapClient.get();
		if(response.getCode()==CoAP.ResponseCode.CONTENT){
			return response.getResponseText();
		}else{
			return null;
		}
	}
	
	public void shutdouwn(){
		coapClient.shutdown();
	}
	
	public static void main(String[] args) {
		CoapResource01Client client = new CoapResource01Client();
		String text= client.get();
		System.out.println(text);
		client.shutdouwn();
	}
}
