/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.led.RgbLedPWM;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ijeongsu
 */
public class RGBLedResource extends CoapResource{
	private static final Logger logger = LoggerFactory.getLogger(RGBLedResource.class);
	//field
	private RgbLedPWM rgbLed;
	private int currentRed;
	private int currentGreen;
	private int currentBlue;
	
	//constructor
	public RGBLedResource() throws Exception{
		super("rgbled");
		rgbLed=new RgbLedPWM(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);
		setColor(0,0,0);
		
	}
	
	
	//method
	
	private void setColor(int red, int green, int blue){
		rgbLed.ledColorSet(red, green, blue);
		currentRed = red;
		currentGreen= green;
		currentBlue=blue;
	}
	
	
	@Override
	public void handleGET(CoapExchange exchange) {
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		//{"command":"change", "led":"100", "green":"100", "blue":"100"}
		//{"command":"status"}
		
		try{
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject= new JSONObject(requestJson);
			String command=requestJsonObject.getString("command");
			if(command.equals("change")){
				int red = Integer.parseInt(requestJsonObject.getString("red"));
				int green = Integer.parseInt(requestJsonObject.getString("green"));
				int blue = Integer.parseInt(requestJsonObject.getString("blue"));
				setColor(red, green, blue);
			}else if(command.equals("status")){

			}

			JSONObject responseJsonObject =new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("red", String.valueOf(currentRed));
			responseJsonObject.put("green", String.valueOf(currentGreen));
			responseJsonObject.put("blue", String.valueOf(currentBlue));
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
