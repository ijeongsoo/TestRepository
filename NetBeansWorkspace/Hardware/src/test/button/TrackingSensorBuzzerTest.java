/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.TrackingSensor;
import hardware.sensor.UltrasonicSensor;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class TrackingSensorBuzzerTest {
	public static void main(String[] args) throws IOException {
		TrackingSensor ts = new TrackingSensor(RaspiPin.GPIO_01);
		
		ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_00);
		ts.setGpioPinListenerDigital((gpdsce) -> {
			if(gpdsce.getState()==PinState.HIGH){
				activeBuzzer.off();
			}else{
				activeBuzzer.on();
			}
		});
		
		System.out.println("Ready");
		System.in.read();
	}
}
