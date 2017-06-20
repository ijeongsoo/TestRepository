/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam03.client;

import java.io.IOException;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class CoapResource03AsyncClient {

	//filed
	private CoapClient coapClient;

	//constructor
	public CoapResource03AsyncClient() {
		coapClient = new CoapClient();

	}
	//method

	public void get(int angle) {
		String queryString = "kind=ultrasonicsensor&angle=" + angle;
		coapClient.setURI("coap://192.168.3.36/resource02?" + queryString);

		coapClient.get(new CoapHandler() {
			@Override
			public void onLoad(CoapResponse response) {

				if (response.getCode() == CoAP.ResponseCode.CONTENT) {
					String text = response.getResponseText();
					System.out.println(angle + "각도의 거리:" + text);
				}

			}

			@Override
			public void onError() {

			}
		});

	}

	public void post(int angle) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("kind", "ultrasonicsensor");
		jsonObject.put("angle", angle);
		String json = jsonObject.toString();
		System.out.println(json);

		coapClient.setURI("coap://192.168.3.36/resource02");
		coapClient.post(new CoapHandler() {
			@Override
			public void onLoad(CoapResponse response) {
				if (response.getCode() == CoAP.ResponseCode.CONTENT) {
					String text = response.getResponseText();
					System.out.println(angle + "각도의 거리:" + text);
				}
			}

			@Override
			public void onError() {
			}
		}, json, MediaTypeRegistry.APPLICATION_JSON);

	}

	public void shutdouwn() {
		coapClient.shutdown();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		CoapResource03AsyncClient client = new CoapResource03AsyncClient();
		for (int i = 20; i < 170; i += 1) {
			client.post(i);
			Thread.sleep(1);
		}
		System.in.read();
		client.shutdouwn();
	}
}
