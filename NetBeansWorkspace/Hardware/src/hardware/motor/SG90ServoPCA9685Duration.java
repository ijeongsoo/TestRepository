/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.motor;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author ijeongsu
 */
public class SG90ServoPCA9685Duration {
	//Field
	private PCA9685 pca9685;
	private Pin pin;
	private int angle;
	private int minDuration;
	private int maxDuration;
	
	
	
	//Constructor
	
	
	public SG90ServoPCA9685Duration(PCA9685 pca9685, Pin pin){
		//0도(0.8ms=800us)
		//180도(2.7ms=2700us)
		this(pca9685, pin, 800, 2700);
	}
	
	public SG90ServoPCA9685Duration(PCA9685 pca9685, Pin pin, int minDuration, int maxDuration){
		this.pca9685=pca9685;
		this.pin=pin;
		this.minDuration=minDuration;
		this.maxDuration=maxDuration;
		
	}
	
	
	//Method
	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		if(angle<0){
			angle=0;
		}else if(angle>=180){
			angle=180;
		}
		this.angle=angle;
		int duration = minDuration +(int)(angle*(maxDuration-minDuration)/180.0);
		this.pca9685.setDuration(pin, duration);
	}

	public static void main(String[] args) throws Exception {
		PCA9685 pca9685 = PCA9685.getInstance();
		SG90ServoPCA9685Duration rlservo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_14);
		SG90ServoPCA9685Duration updownServo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_15);
		SG90ServoPCA9685Duration distanceServo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_11);
		SG90ServoPCA9685Duration tireServo = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_00);
		
		rlservo.setAngle(20);
		Thread.sleep(1000);
		rlservo.setAngle(160);
		Thread.sleep(1000);
		rlservo.setAngle(90);
		Thread.sleep(3000);
		
		
		updownServo.setAngle(20);
		Thread.sleep(1000);
		updownServo.setAngle(160);
		Thread.sleep(1000);
		updownServo.setAngle(90);
		Thread.sleep(3000);
//		
		distanceServo.setAngle(20);
		Thread.sleep(1000);
		distanceServo.setAngle(130);
		Thread.sleep(1000);
		distanceServo.setAngle(90);
		Thread.sleep(3000);
		
		tireServo.setAngle(50);
		Thread.sleep(1000);
		tireServo.setAngle(130);
		Thread.sleep(1000);
		tireServo.setAngle(90);
		Thread.sleep(3000);
		
	}
		
	
	
	
}
