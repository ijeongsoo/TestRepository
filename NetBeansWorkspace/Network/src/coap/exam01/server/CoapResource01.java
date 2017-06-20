/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam01.server;

import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author ijeongsu
 */
public class CoapResource01 extends CoapResource{
	private ThermistorSensor thermistorSensor;
	
	public CoapResource01() {
		super("resource01");
		PCF8591 pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
		thermistorSensor=new ThermistorSensor(pcf8591);
	}
	
	@Override
	public void handleGET(CoapExchange exchange) {
		double value;
		try {
			value = thermistorSensor.getValue();
			exchange.respond("온도: 섭씨"+value+"도");
			//exchange.respond("this is test");
		} catch (Exception ex) {
		}
		
	}
	
	
}
