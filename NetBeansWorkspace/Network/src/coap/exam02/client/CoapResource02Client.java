/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam02.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class CoapResource02Client {

	//filed
	private CoapClient coapClient;

	//constructor
	public CoapResource02Client() {
		coapClient = new CoapClient();
		coapClient.useCONs(); //default
		//coapClient.useNONs();
	}
	//method

	public String get(int angle) {
		String queryString = "kind=ultrasonicsensor&angle=" + angle;
		coapClient.setURI("coap://192.168.3.36/resource02?" + queryString);

		CoapResponse response = coapClient.get();
		if (response == null) {
			return get(angle);
		} else {
			if (response.getCode() == CoAP.ResponseCode.CONTENT) {
				return response.getResponseText();
			} else {
				return get(angle);
			}
		}

	}

	public String post(int angle) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("kind", "ultrasonicsensor");
		jsonObject.put("angle", angle);
		String json = jsonObject.toString();
		System.out.println(json);

		coapClient.setURI("coap://192.168.3.36/resource02");
		CoapResponse response = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		
		if (response == null) {
			return post(angle);
		} else {
			if (response.getCode() == CoAP.ResponseCode.CONTENT) {
				return response.getResponseText();
			} else {
				return post(angle);
			}
		}
		
	}

	public void shutdouwn() {
		coapClient.shutdown();
	}

	public static void main(String[] args) throws InterruptedException {
		CoapResource02Client client = new CoapResource02Client();
		for (int i = 20; i < 170; i += 10) {
			String text = client.post(i);
			System.out.println(i + "각도의 거리:" + text);
			Thread.sleep(100);
		}

		client.shutdouwn();
	}
}
