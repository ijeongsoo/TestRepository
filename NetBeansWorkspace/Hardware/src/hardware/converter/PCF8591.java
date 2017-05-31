/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.converter;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;

/**
 *
 * @author ijeongsu
 */

public class PCF8591 {
	public static final int AIN0=0x40;
	public static final int AIN1=0x41;
	public static final int AIN2=0x42;
	public static final int AIN3=0x43;
	
	private int i2cAddress;
	private int ainNo;
	private int analogVal;

	public PCF8591(int i2cAddress, int ainNo) {
		this.i2cAddress=i2cAddress;
		this.ainNo=ainNo;
	}
	
	public int analogRead() throws Exception{
		I2CBus i2cBus = I2CFactory.getInstance(I2CBus.BUS_1);
		I2CDevice i2cDevice = i2cBus.getDevice(i2cAddress);
		i2cDevice.read(ainNo); //dummy read
		analogVal=i2cDevice.read(ainNo); //0~255
		return analogVal;
	}
	
	public void analogWrite(byte value) throws Exception{
		I2CBus i2cBus = I2CFactory.getInstance(I2CBus.BUS_1);
		I2CDevice i2cDevice = i2cBus.getDevice(i2cAddress);
		i2cDevice.write(AIN0, value);
	}
	
	public static void main(String[] args) throws Exception {
		PCF8591 p = new PCF8591(0x48, AIN0);
		while(true){
			//아날로그 값읽기 
			int value = p.analogRead();
			System.out.println(value);
			//아날로그 값 출력 
			p.analogWrite((byte)value);
			
			Thread.sleep(200);
		}
	}
}
