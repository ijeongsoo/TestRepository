/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.converter.PCF8591;
import hardware.sensor.PhotoresistorSensor;
import hardware.sensor.TrackingSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ijeongsu
 */
public class TrackingSensorResource extends CoapResource{
	private static final Logger logger = LoggerFactory.getLogger(TrackingSensorResource.class);
	//field
	private TrackingSensor trackingSensor;
	private String currentColor;
	
	//constructor
	public TrackingSensorResource() throws Exception{
		super("tracking");
		setObservable(true);
		getAttributes().setObservable();
		setObserveType(CoAP.Type.NON);
		
		trackingSensor=new TrackingSensor(RaspiPin.GPIO_26);
				
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try{
						PinState pinState= trackingSensor.getStatus();
						if(pinState==PinState.HIGH) currentColor="black";
						else currentColor="white";
						changed();
						Thread.sleep(1000);
					}catch(Exception e){
						logger.info(e.toString());
					}
				}
			}
			
		};
		thread.start();
		
//		trackingSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
//			@Override
//			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//				PinState pinState=event.getState();
//				if(pinState==pinState.HIGH){
//					BuzzerResource.getInstance().off();
//				}else{
//					BuzzerResource.getInstance().on();
//				}
//			}
//		});
				
	}
	
	
	//method
	
	
	
	@Override
	public void handleGET(CoapExchange exchange) {
		JSONObject responseJsonObject = new JSONObject();
		responseJsonObject.put("tracking", currentColor);
		String responseJson= responseJsonObject.toString();
		exchange.respond(responseJson);
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		//{"command":"status"}
		
		try{
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject= new JSONObject(requestJson);
			String command=requestJsonObject.getString("command");
			
			if(command.equals("status")){

			}

			JSONObject responseJsonObject =new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("tracking", currentColor);

			String responseJson = responseJsonObject.toString();
		
			exchange.respond(responseJson);
		}catch(Exception e){
			logger.info(e.toString());
			  JSONObject responseJsonObject =new JSONObject();
			responseJsonObject.put("result", "fail");

			String responseJson = responseJsonObject.toString();
		
			exchange.respond(responseJson);
		}
	}
	
	
}
