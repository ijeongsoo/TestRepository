/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.button.Button;
import hardware.buzzer.ActiveBuzzer;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class ButtonActiveBuzzerTest {
	public static void main(String[] args) throws IOException {
		Button button1 = new Button(RaspiPin.GPIO_00);
		ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_01);
		
		button1.setGpioPinListenerDigital((gpdsce) -> {
			if(gpdsce.getState()==PinState.LOW){
				activeBuzzer.on();
			}else{
				activeBuzzer.off();
			}
		});
		
		System.out.println("Ready....");
		System.in.read();
		
	}
}
