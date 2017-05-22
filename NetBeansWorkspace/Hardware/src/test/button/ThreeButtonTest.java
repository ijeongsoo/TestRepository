/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.button.Button;
import hardware.led.RgbLed;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class ThreeButtonTest {
	public static void main(String[] args) throws IOException {
		Button button1 = new Button(RaspiPin.GPIO_00);
		Button button2 = new Button(RaspiPin.GPIO_01);
		Button button3 = new Button(RaspiPin.GPIO_02);
		
		RgbLed test = new RgbLed(RaspiPin.GPIO_27, RaspiPin.GPIO_28,RaspiPin.GPIO_29);
		button1.setGpioPinListenerDigital((gpdsce) -> {	
			if(gpdsce.getState()==PinState.LOW){
				test.red(true);
			}else{
				test.red(false);
			}
		});
		button2.setGpioPinListenerDigital((gpdsce) -> {
			if(gpdsce.getState()==PinState.LOW){
				test.green(true);
			}else{
				test.green(false);
			}
		});
		
		button3.setGpioPinListenerDigital((gpdsce) -> {
			if(gpdsce.getState()==PinState.LOW){
				test.blue(true);
			}else{
				test.blue(false);
			}
		});
		
		System.out.println("Ready....");
		System.in.read();
		
	}
}
