/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.motor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;

/**
 *
 * @author ijeongsu
 */
public class SG90Servo {
	//field
	private GpioPinPwmOutput pin;
	private int angle;
	private double minStep;
	private double maxStep;
	
	//constructor
	public SG90Servo(Pin pinNo){
		this(pinNo, 8, 27);
	}
	
	public SG90Servo(Pin pinNo, double minStep, double maxStep){
		GpioController gpioController=GpioFactory.getInstance();
		pin=gpioController.provisionPwmOutputPin(pinNo);
		
		Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
		Gpio.pwmSetClock(1920);
		Gpio.pwmSetRange(200);
		
		this.minStep= minStep;
		this.maxStep=maxStep;
		
		
	}
	
	
	
	//methode

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		if(angle<0){
			angle=0;
		}else if(angle>180){
			angle=180;
		}
		this.angle = angle;
		int step=(int)(minStep+(angle*(maxStep-minStep)/180.0));
		pin.setPwm(step);
	}
	
	public static void main(String[] args) throws InterruptedException {
		SG90Servo sg90servo = new SG90Servo(RaspiPin.GPIO_01, 8, 27);
		sg90servo.setAngle(0);
		Thread.sleep(3000);
		sg90servo.setAngle(90);
		Thread.sleep(3000);
		sg90servo.setAngle(180);
		Thread.sleep(3000);
	}
	
}
