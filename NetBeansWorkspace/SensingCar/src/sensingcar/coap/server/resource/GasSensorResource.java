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
import hardware.sensor.GasSensor;
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
public class GasSensorResource extends CoapResource{
	private static final Logger logger = LoggerFactory.getLogger(GasSensorResource.class);
	//field
	private GasSensor gasSensor;
	private PCF8591 pcf8591;
	private double currentValue;
	
	//constructor
	public GasSensorResource() throws Exception{
		super("gassensor");
		setObservable(true);
		getAttributes().setObservable();
		setObserveType(CoAP.Type.NON);
		pcf8591= new PCF8591(0x48, PCF8591.AIN2);
		gasSensor=new GasSensor(pcf8591,RaspiPin.GPIO_23);
				
		Thread thread = new Thread(){
			@Override
			public void run() {
				while(true){
					try{
						currentValue= gasSensor.getValue();
						
						changed();
						Thread.sleep(1000);
					}catch(Exception e){
						logger.info(e.toString());
					}
				}
			}
			
		};
		thread.start();
		
//		gasSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
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
		responseJsonObject.put("gas", String.valueOf(currentValue));
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
			responseJsonObject.put("gas", String.valueOf(currentValue));

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
