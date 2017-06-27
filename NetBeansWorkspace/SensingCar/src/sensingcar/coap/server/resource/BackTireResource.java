/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.coap.server.resource;

import com.pi4j.io.gpio.RaspiPin;
import hardware.motor.DCMotor;
import hardware.motor.PCA9685;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ijeongsu
 */
public class BackTireResource extends CoapResource{
	private static final Logger logger = LoggerFactory.getLogger(BackTireResource.class);
	//field
	private DCMotor dcMotorLeft;
	private DCMotor dcMotorRight;
	private PCA9685 pca9685;
	private final int maxStep =4095;
	private final int minStep =0;
	private String currentDirection;
	private int currentStep;
	

	//constructor
	
	public BackTireResource() throws Exception{
		super("backtire");
		pca9685=PCA9685.getInstance();
		dcMotorLeft=new DCMotor(RaspiPin.GPIO_00, RaspiPin.GPIO_01, pca9685, PCA9685.PWM_05);
		dcMotorRight=new DCMotor(RaspiPin.GPIO_02, RaspiPin.GPIO_03, pca9685, PCA9685.PWM_04);
		forward();
	}
	
	
	//method
	public void forward(){
		dcMotorLeft.forward();
		dcMotorRight.forward();
		currentDirection="forward";
	}
	
	public void backward(){
		dcMotorLeft.backward();
		dcMotorRight.backward();
		currentDirection="backward";
	}
	
	public void setSpeed(int step){
		if(step<minStep) step=minStep;
		if(step>maxStep) step=maxStep;
		currentStep=step;
		dcMotorLeft.setSpeed(currentStep);
		dcMotorRight.setSpeed(currentStep);
	}
	
	public void stop(){
		dcMotorLeft.stop();
		dcMotorRight.stop();
	}

	@Override
	public void handleGET(CoapExchange exchange) {
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		//{"command":"change", "direction":"forward", "speed":"1000"}
		//{"command":"getStatus"}
		try{
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject= new JSONObject(requestJson);
			String command=requestJsonObject.getString("command");
			if(command.equals("change")){
				String reqDirection=requestJsonObject.getString("direction");
				int reqSpeed = Integer.parseInt(requestJsonObject.getString("speed"));
				if(reqDirection.equals("forward")){
					forward();
				}else if(reqDirection.equals("backward")){
					backward();
				}
				setSpeed(reqSpeed);		
			}else if(command.equals("status")){

			}

			JSONObject responseJsonObject =new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("direction", currentDirection);
			responseJsonObject.put("speed", String.valueOf(currentStep));

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
