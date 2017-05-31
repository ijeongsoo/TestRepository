/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.RaspiPin;
import hardware.buzzer.ActiveBuzzer;
import hardware.converter.PCF8591;
import hardware.sensor.ThermistorSensor;

/**
 *
 * @author ijeongsu
 */
public class ThermistorSensorBuzzerTest {
	public static void main(String[] args) throws InterruptedException, Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		ThermistorSensor test = new ThermistorSensor(pcf8591);
		ActiveBuzzer buzzer = new ActiveBuzzer(RaspiPin.GPIO_00);
		while(true){
			double value = test.getValue();
			System.out.println(value+"도");
			if(value>28){
				buzzer.on();
			}else{
				buzzer.off();
			}
			Thread.sleep(1000);
		}
	}
	
}
