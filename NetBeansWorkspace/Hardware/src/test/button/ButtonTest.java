/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.button.Button;
import hardware.led.DualColorLed;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class ButtonTest {
	public static void main(String[] args) throws IOException {
		Button button = new Button(RaspiPin.GPIO_00);
		DualColorLed dc = new DualColorLed(RaspiPin.GPIO_01, RaspiPin.GPIO_02);
		button.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
				if(gpdsce.getState()==PinState.LOW){
					dc.red();
				}else{
					dc.green();
				}
			}
		});
		
		System.out.println("Ready....");
		System.in.read();
		
	}
}
