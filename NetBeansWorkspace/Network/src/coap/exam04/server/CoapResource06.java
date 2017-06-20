/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam04.server;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.motor.DCMotor;
import hardware.motor.PCA9685;
import hardware.sensor.GasSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author ijeongsu
 */
public class CoapResource06 extends CoapResource {

	//field
	private double gas;
	private String beforeAlam;
	private String alam = "정상상태!";
	private PCF8591 pcf8591;
	private GasSensor gasSensor;
	private ActiveBuzzer buzzer;
	private DCMotor motorA;
	private DCMotor motorB;
	private PCA9685 pca9685;
	//constructor

	public CoapResource06() throws Exception {
		super("resource06");
		//관찰기능 활성화
		setObservable(true);
		//관찰기능을 제공하다라는 것을 클라이언트가 알수 잇도록 설정 
		getAttributes().setObservable();
		pcf8591 = new PCF8591(0x48, PCF8591.AIN2);
		gasSensor = new GasSensor(pcf8591, RaspiPin.GPIO_23);
		buzzer = new ActiveBuzzer(RaspiPin.GPIO_24);
		pca9685 = PCA9685.getInstance();
		motorA = new DCMotor(RaspiPin.GPIO_00, RaspiPin.GPIO_01, pca9685, PCA9685.PWM_05);
		motorB = new DCMotor(RaspiPin.GPIO_02, RaspiPin.GPIO_03, pca9685, PCA9685.PWM_04);
		//test
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
//						gasSensor.setGpioPinListenerDigital(new GpioPinListenerDigital() {
//							@Override
//							public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
//								if (gpdsce.getState() == PinState.LOW) {
//									//beforeAlam = alam;
//									alam = "가스발생!";
//									changed();
//									buzzer.on();
//									motorA.forward();
//									motorA.setSpeed(2095);
//									motorB.forward();
//									motorB.setSpeed(2095);
//								} else {
//									//beforeAlam = alam;
//									alam = "정상상태!";
//									changed();
//									buzzer.off();
//									motorA.stop();
//									motorB.stop();
//								}
//							}
//						});

						gas = gasSensor.getValue();
						if (gas > 200) {
							beforeAlam = alam;
							alam = "가스발생!";
							if (!alam.equals(beforeAlam)) {
								changed();
							}
							buzzer.on();
							motorA.forward();
							motorB.forward();
							motorA.setSpeed(2095);
							motorB.setSpeed(2095);
						} else {
							beforeAlam = alam;
							alam = "정상상태!";
							if (!alam.equals(beforeAlam)) {
								changed();
							}
							buzzer.off();
							motorA.stop();
							motorB.stop();
						}
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
		exchange.respond(alam);
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
	}

}
