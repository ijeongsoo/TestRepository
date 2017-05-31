/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.button.Button;
import hardware.motor.SG90Servo;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class ButtonSG90ServoTest {
	
	public static void main(String[] args) throws IOException {
		Button button = new Button(RaspiPin.GPIO_00);
		SG90Servo ss= new SG90Servo(RaspiPin.GPIO_01);
		
		button.setGpioPinListenerDigital((gpdsce) -> {
			if(gpdsce.getState()==PinState.LOW){
				ss.setAngle(180);
			}else{
				ss.setAngle(0);
			}
		
		});
		
		System.in.read();
	}
	
}
