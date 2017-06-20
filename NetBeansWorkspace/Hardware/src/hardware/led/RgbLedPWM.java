/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.led;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */
public class RgbLedPWM {

	//feild
	private GpioPinPwmOutput redPin;
	private GpioPinPwmOutput greenPin;
	private GpioPinPwmOutput bluePin;
	private int[] currColorSet = new int[3];

	//constructor
	public RgbLedPWM(Pin redPinNo, Pin greenPinNo, Pin bluePinNo) {
		GpioController gpioController = GpioFactory.getInstance();
		//소프트웨어 PWM 출력 핀 객체 생성
		redPin = gpioController.provisionSoftPwmOutputPin(redPinNo);
		greenPin = gpioController.provisionSoftPwmOutputPin(greenPinNo);
		bluePin = gpioController.provisionSoftPwmOutputPin(bluePinNo);
		
		
		
		//제어단계를 255단계로 한다!
		redPin.setPwmRange(255);
		greenPin.setPwmRange(255);
		bluePin.setPwmRange(255);
		ledColorSet(0, 0, 0);

	}

	//method

	public int[] getCurrColorSet() {
		return currColorSet;
	}
	
	
	
	public void ledColorSet(int r, int g, int b){
		currColorSet[0]=r;
		currColorSet[1]=g;
		currColorSet[2]=b;
		r=255-r;
		g=255-g;
		b=255-b;
		redPin.setPwm(r);
		greenPin.setPwm(g);
		bluePin.setPwm(b);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		RgbLedPWM rlp = new RgbLedPWM(RaspiPin.GPIO_04, RaspiPin.GPIO_05, RaspiPin.GPIO_06);

		rlp.ledColorSet(255, 0, 0); Thread.sleep(1000);
		rlp.ledColorSet(0, 255, 0); Thread.sleep(1000);
		rlp.ledColorSet(0, 0, 255); Thread.sleep(1000);
		rlp.ledColorSet(255, 255, 0); Thread.sleep(1000);
		rlp.ledColorSet(0, 255, 255); Thread.sleep(1000);
		rlp.ledColorSet(255, 0, 255); Thread.sleep(1000);
		rlp.ledColorSet(0, 0, 0);

		System.out.println("Read...");
		System.in.read();
	}

}
