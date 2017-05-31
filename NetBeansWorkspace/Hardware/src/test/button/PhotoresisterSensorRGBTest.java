/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.button;

import com.pi4j.io.gpio.RaspiPin;
import hardware.converter.PCF8591;
import hardware.led.RgbLedDigital;
import hardware.led.RgbLedPWM;
import hardware.sensor.PhotoresistorSensor;

/**
 *
 * @author ijeongsu
 */
public class PhotoresisterSensorRGBTest{
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		PhotoresistorSensor test = new PhotoresistorSensor(pcf8591);
		RgbLedPWM rgbLedPWM = new RgbLedPWM(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		while(true){
			double value = test.getValue();
			System.out.println(value);
			rgbLedPWM.ledColorSet((int)value, 0, 0);
			Thread.sleep(1000);
		}
	}
}
