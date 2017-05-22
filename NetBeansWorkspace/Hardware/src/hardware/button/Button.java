/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.button;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class Button {
	//field
	private GpioPinDigitalInput gpioPinDigitalInput;
	
	//constructor
	public Button(Pin buttonPinNo){
		GpioController gpioController = GpioFactory.getInstance();
		gpioPinDigitalInput=gpioController.provisionDigitalInputPin(buttonPinNo);
		gpioPinDigitalInput.setShutdownOptions(true);
		
		
	}
	
	//method
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital listener)
	{
		gpioPinDigitalInput.addListener(listener);
	}	
	
	
	public static void main(String[] args) throws IOException {
		Button button = new Button(RaspiPin.GPIO_00);
		button.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
				if(event.getState()==PinState.HIGH){
					System.out.println("higt");
				}else{
					System.out.println("low");
				}
			}
		});
		
		System.out.println("Ready....");
		System.in.read();
	}
}
