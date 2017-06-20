/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.buzzer;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author ijeongsu
 */
public class ActiveBuzzer {
	//field
	private GpioPinDigitalOutput buzzerPin;
	private String status="off";
	//Constructor
	public ActiveBuzzer(Pin buzzerPinNO){
		GpioController gpioController = GpioFactory.getInstance();
		buzzerPin = gpioController.provisionDigitalOutputPin(buzzerPinNO, PinState.HIGH);
		buzzerPin.setShutdownOptions(false, PinState.HIGH);
	}
	
	//Method
	public void on(){
		buzzerPin.low();
		status="on";
	}
	
	public void off(){
		buzzerPin.high();
		status="off";
	}

	public String getStatus() {
		return status;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ActiveBuzzer test = new ActiveBuzzer(RaspiPin.GPIO_24);
		
		for(int i=0; i<10; i++){
			test.on();
			Thread.sleep(1000);
			test.off();
			Thread.sleep(200);
		}
	}
	
}
