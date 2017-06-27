/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.coap.server.resource;

import hardware.motor.PCA9685;
import hardware.motor.SG90ServoPCA9685Duration;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ijeongsu
 */
public class FrontTireResource extends CoapResource{
	private static final Logger logger = LoggerFactory.getLogger(FrontTireResource.class);
	//field
	private PCA9685 pca9685;
	private SG90ServoPCA9685Duration servoMotor;
	private final int minAngle=60;
	private final int maxAngle=120;
	private int currentAngle; 

	//constructor
	
	public FrontTireResource() throws Exception{
		super("fronttire");
		pca9685=PCA9685.getInstance();
		servoMotor = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_00);
		setAngle(90);
	}
	
	
	//method
	private void setAngle(int angle){
		if(angle<minAngle) angle=minAngle;
		if(angle>maxAngle) angle=maxAngle;
		servoMotor.setAngle(angle);
		currentAngle=angle;
	}

	@Override
	public void handleGET(CoapExchange exchange) {
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		//{"command":"change", "angle":"90"}
		//{"command":"status"}
		
		try{
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject= new JSONObject(requestJson);
			String command=requestJsonObject.getString("command");
			if(command.equals("change")){
				int angle = Integer.parseInt(requestJsonObject.getString("angle"));
				setAngle(angle);
						
			}else if(command.equals("status")){

			}

			JSONObject responseJsonObject =new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("angle", String.valueOf(currentAngle));

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
