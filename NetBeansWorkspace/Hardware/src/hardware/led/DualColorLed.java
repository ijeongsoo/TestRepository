/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author ijeongsu
 */
public class DualColorLed {

	//Field
	//디지털 출력핀 필드
	private GpioPinDigitalOutput redPin;
	//디지털 출력핀 필드
	private GpioPinDigitalOutput greenPin;

	//Constructor
	public DualColorLed(Pin redPinNo, Pin greenPinNo) {
		//GpioController 객체 얻기 
		GpioController gpioController = GpioFactory.getInstance();
		//디지털 출력핀 생성
		redPin = gpioController.provisionDigitalOutputPin(redPinNo);
		//어플리케이션 종료시 출력모드 해제하고 핀의 출력을 LOW
		redPin.setShutdownOptions(true, PinState.HIGH);
		greenPin = gpioController.provisionDigitalOutputPin(greenPinNo);
		greenPin.setShutdownOptions(true, PinState.HIGH);
	}

	//Method
	
	public void red() {
		redPin.high();
		greenPin.low();
	}

	public void green() {
		greenPin.high();
		redPin.low();
	}

	public static void main(String[] args) throws InterruptedException {

		DualColorLed test = new DualColorLed(RaspiPin.GPIO_00, RaspiPin.GPIO_01);

		for(int i=0; i<3; i++){
			test.green();
			Thread.sleep(1000);
			test.red();
			Thread.sleep(1000);
		}

	}
}
