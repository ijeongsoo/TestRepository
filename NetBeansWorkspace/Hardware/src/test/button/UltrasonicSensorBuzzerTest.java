/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.sensor.UltrasonicSensor;

/**
 *
 * @author ijeongsu
 */
public class UltrasonicSensorBuzzerTest {
	public static void main(String[] args) throws InterruptedException {
		UltrasonicSensor us = new UltrasonicSensor(RaspiPin.GPIO_01, RaspiPin.GPIO_02);
		ActiveBuzzer activeBuzzer = new ActiveBuzzer(RaspiPin.GPIO_00);
		while(true){
			System.out.println("거리(Cm):"+us.getDistance());
			Thread.sleep(50);
			if(us.getDistance()<15){
				activeBuzzer.on();
			}else{
				activeBuzzer.off();
			}
		}
	}
}
