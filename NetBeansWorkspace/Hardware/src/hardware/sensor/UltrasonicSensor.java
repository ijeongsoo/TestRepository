/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.sensor;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author ijeongsu
 */
public class UltrasonicSensor {
	//field
	private GpioPinDigitalOutput triggerPin;
	private GpioPinDigitalInput echoPin;
	private int previousDistance;
	private boolean again;
	private int count;
	
	//constructor
	
	public UltrasonicSensor(Pin triggerPinNo, Pin echoPinNo) {	
		GpioController gpioController = GpioFactory.getInstance();
		
		triggerPin = gpioController.provisionDigitalOutputPin(triggerPinNo, PinState.LOW);
		triggerPin.setShutdownOptions(true, PinState.LOW);
		
		echoPin = gpioController.provisionDigitalInputPin(echoPinNo);
		echoPin.setShutdownOptions(true, PinState.LOW);
	}
	
	public int getDistance(){
		//초음파 발신 시간 변수와 수신시간 변수 선언 
		double start=0;
		double end=0;
		
		
		
		//초음파를 10마이크로초 동안 발생 
		triggerPin.high();
		try{
			Thread.sleep(0, 10000);
		}catch(Exception e){}
		triggerPin.low();
		
		//echoPin이 High가 될때까지 기다림 
		count=0;
		while(echoPin.isLow()){
			count++;
			if(count>50000){
				return getDistance();
			}
		}
		//발신시간을 저장
		start=System.nanoTime();
		
		//echoPin이 Low가 될때까지 기다림
		//count=0;
		while(echoPin.isHigh()){
		count++;
			if(count>50000){
				return getDistance();
			}
		}
		//수신 시간을 저장
		end=System.nanoTime();
		//편도시간 
		double second=(end-start)/1000000000/2;
		//거리 
		int distance = (int)(second*34000);
		//100이상 튀는값이 있을경우 다시 측정
		if(again==false && Math.abs(previousDistance-distance)>100){
			again=true;
			getDistance();
			distance = getDistance();
			
		}else{
			again=false;
		}
		//초과값 처리
		if(distance<2){
			distance=2;
		}else if(distance>400){
			distance=400;
		}
		
		previousDistance =distance;		
		return distance;
	}

	//method
	public static void main(String[] args) throws InterruptedException {
		
		UltrasonicSensor us = new UltrasonicSensor(RaspiPin.GPIO_28, RaspiPin.GPIO_29);
		while(true){
			System.out.println("거리(Cm):"+us.getDistance());
			Thread.sleep(300);
		}
	}
}
