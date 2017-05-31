/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import hardware.sensor.*;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.led.DualColorLed;
import hardware.motor.SG90Servo;

/**
 *
 * @author ijeongsu
 */
public class GasSensorBuzzerDualLedServoMotorTest {
	private PCF8591 pcf8591;
	private GpioPinDigitalInput gpioPinDigitalInput;
	
	public GasSensorBuzzerDualLedServoMotorTest(PCF8591 pcf8591, Pin digitalPinNo){
		this.pcf8591=pcf8591;
		GpioController gpioController = GpioFactory.getInstance();
		gpioPinDigitalInput=gpioController.provisionDigitalInputPin(digitalPinNo);
		gpioPinDigitalInput.setShutdownOptions(true, PinState.LOW);
	}
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital listener){
		gpioPinDigitalInput.addListener(listener);
		
	}
	
	public double getValue() throws Exception{
		int analogVal=pcf8591.analogRead();
		return analogVal;
	}
	
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		GasSensorBuzzerDualLedServoMotorTest test = new GasSensorBuzzerDualLedServoMotorTest(pcf8591, RaspiPin.GPIO_00);
		DualColorLed led = new DualColorLed(RaspiPin.GPIO_04, RaspiPin.GPIO_02);
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_03);
		SG90Servo sg90servo = new SG90Servo(RaspiPin.GPIO_01, 8, 27);
		led.green();
		sg90servo.setAngle(0);
		//Digital 핀의 상태를 이용
		test.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
				if(gpdsce.getState()==PinState.LOW){
					led.red();
					buzzer.on();
					sg90servo.setAngle(180);
					
					
				}else{
					led.green();
					buzzer.off();
					sg90servo.setAngle(0);
					
				}
			}
		});
		
		System.in.read();

		
	}
	
}
