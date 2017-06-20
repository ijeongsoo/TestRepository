/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam04.server;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author ijeongsu
 */
public class CoapResource05 extends CoapResource {

	//field
	private double temperature;
	private ThermistorSensor thermistorSensor;
	private PCF8591 pcf8591;
	//constructor

	public CoapResource05() {
		super("resource05");
		//관찰기능 활성화
		setObservable(true);
		//관찰기능을 제공하다라는 것을 클라이언트가 알수 잇도록 설정 
		getAttributes().setObservable();
		pcf8591 = new PCF8591(0x48, PCF8591.AIN1);
		thermistorSensor = new ThermistorSensor(pcf8591);

		//test
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						temperature = thermistorSensor.getValue();
						changed();

						Thread.sleep(1000);
					} catch (Exception ex) {
					}
				}
			}

		};

		thread.start();
	}

	//method
	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond("temperature=" + temperature);
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
	}

}
