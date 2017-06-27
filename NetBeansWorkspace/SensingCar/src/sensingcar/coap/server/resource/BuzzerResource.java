/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ijeongsu
 */
public class BuzzerResource extends CoapResource{
	private static final Logger logger = LoggerFactory.getLogger(BuzzerResource.class);
	//field
	private ActiveBuzzer buzzer;
	private String currentStatus;
	private static BuzzerResource instance;
	//constructor
	
	public BuzzerResource() throws Exception{
		super("buzzer");
		instance = this;
		buzzer=new ActiveBuzzer(RaspiPin.GPIO_24);
		off();
	}
	
	public static BuzzerResource getInstance(){
		return instance;
	}
	
	//method
	public void on(){
		buzzer.on();
		currentStatus="on";
	}
	
	public void off(){
		buzzer.off();
		currentStatus="off";
	}

	@Override
	public void handleGET(CoapExchange exchange) {
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		//{"command":"change", "status":"on"}
		//{"command":"status"}
		
		try{
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject= new JSONObject(requestJson);
			String command=requestJsonObject.getString("command");
			if(command.equals("change")){
				String status= requestJsonObject.getString("status");
				if(status.equals("on")) on();
				else if(status.equals("off")) off();
						
			}else if(command.equals("status")){

			}

			JSONObject responseJsonObject =new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("status", currentStatus);

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
