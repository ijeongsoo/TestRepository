/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class TrackingSensor {
	private GpioPinDigitalInput trackingPin;

	public TrackingSensor(Pin trackingPinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		trackingPin = gpioController.provisionDigitalInputPin(trackingPinNo);
		trackingPin.setShutdownOptions(true, PinState.LOW);
	}
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital gpioPinListenerDigital){
		trackingPin.addListener(gpioPinListenerDigital);
		
	}
	
	public PinState getStatus(){
		return trackingPin.getState();
	}
	
	
	public static void main(String[] args) throws IOException {
		TrackingSensor test= new TrackingSensor(RaspiPin.GPIO_26);
		test.setGpioPinListenerDigital((gpdsce) -> {
			if(gpdsce.getState()==PinState.HIGH){
				System.out.println("BLACK");
			}else{
				System.out.println("WHITE");
			}
		});
		
		System.out.println("Ready");
		System.in.read();
	}
	
}
