/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam05.client;

import javax.xml.validation.Schema;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Request;

/**
 *
 * @author ijeongsu
 */
public class Coap2CoapClient {
	private CoapClient coapClient;

	public Coap2CoapClient() {
		coapClient = new CoapClient();
	}
	
	public String coap2coap(){
		//Proxy 접근 주소 
		coapClient.setURI("coap://localhost:5683/coap2coap");
		//foward 되는 리소스의 통신 방법 
		Request request = new Request(CoAP.Code.GET);
		//forward되는 리소스의 uri
		request.getOptions().setProxyUri("coap://localhost/resource01");
		
		System.out.println(request.getOptions().getProxyScheme());
		CoapResponse response = coapClient.advanced(request);
		
		if(response.getCode()==CoAP.ResponseCode.CONTENT){
			return response.getResponseText();
		}else{
			return null;
		}
	}
	
	public void shutdown(){
		coapClient.shutdown();
	}
	
	public static void main(String[] args) {
		Coap2CoapClient client = new Coap2CoapClient();
		String text=client.coap2coap();
		System.out.println(text);
		client.shutdown();
	}
	
}
