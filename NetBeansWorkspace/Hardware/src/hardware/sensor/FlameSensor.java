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
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import hardware.converter.PCF8591;

/**
 *
 * @author ijeongsu
 */
public class FlameSensor {
	private PCF8591 pcf8591;
	private GpioPinDigitalInput gpioPinDigitalInput;
	
	public FlameSensor(PCF8591 pcf8591, Pin digitalPinNo){
		this.pcf8591=pcf8591;
		GpioController gpioController = GpioFactory.getInstance();
		gpioPinDigitalInput=gpioController.provisionDigitalInputPin(digitalPinNo);
		gpioPinDigitalInput.setShutdownOptions(true, PinState.LOW);
	}
	
	public void setGpioPinListenerDigital(GpioPinListenerDigital listener){
		gpioPinDigitalInput.addListener(listener);
		
	}
	
	public double getValue() throws Exception{
		int analogVal=pcf8591.analogRead();
		return analogVal;
	}
	
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN0);
		FlameSensor test = new FlameSensor(pcf8591, RaspiPin.GPIO_00);
		
		//Digital 핀의 상태를 이용
		test.setGpioPinListenerDigital(new GpioPinListenerDigital() {
			@Override
			public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
				if(gpdsce.getState()==PinState.LOW){
					System.out.println("*********화제 발생!!!!********");
				}else{
					System.out.println("*********정상상태!!!********");
				}
			}
		});
		
		//아날로그 값을 이용해서 처리
		
		while(true){
			double value = test.getValue();
			System.out.println(value);
			if(value<100){
				
			}
			Thread.sleep(1000);
		}

		
	}
	
}
