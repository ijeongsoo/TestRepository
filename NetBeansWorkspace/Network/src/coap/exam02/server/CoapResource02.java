/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam02.server;

import com.pi4j.io.gpio.RaspiPin;
import hardware.converter.PCF8591;
import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685Duration;
import hardware.sensor.UltrasonicSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;

/**
 *
 * @author ijeongsu
 */
public class CoapResource02 extends CoapResource{

	SG90ServoPCA9685Duration servo;
	PCA9685 pca9685;
	UltrasonicSensor us;
	private int distance;
	
	public CoapResource02() throws Exception {
		super("resource02");
		pca9685 = PCA9685.getInstance();
		servo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_11);
		us = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					distance= us.getDistance();
					try{Thread.sleep(100);} catch(Exception e){}
				}
			}
			
		};
		thread.start();
		
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		String kind = exchange.getRequestOptions().getUriQuery().get(0).split("=")[1];
		String angle = exchange.getRequestOptions().getUriQuery().get(1).split("=")[1];
		System.out.println("key1:"+kind);
		System.out.println("key2:"+angle);
		
		if(kind.equals("ultrasonicsensor")){
			servo.setAngle(Integer.parseInt(angle));
			try{Thread.sleep(200);}catch(Exception e){}
			exchange.respond(String.valueOf(distance));
			
		}else{
			exchange.respond("nope");
		}
		
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		String json = exchange.getRequestText();
		JSONObject jsonObject= new JSONObject(json);

		String kind= jsonObject.getString("kind");
		int angle = jsonObject.getInt("angle");
		
		if(kind.equals("ultrasonicsensor")){
			servo.setAngle(angle);
			try{Thread.sleep(200);}catch(Exception e){}
			exchange.respond(String.valueOf(distance));
			
		}else{
			exchange.respond("nope");
		}
	}
	
	
	
	
	
}
