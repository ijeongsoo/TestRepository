/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardware.sensor;

import hardware.converter.PCF8591;

/**
 *
 * @author ijeongsu
 */
public class ThermistorSensor {
	private PCF8591 pcf8591;
	
	public ThermistorSensor(PCF8591 pcf8591){
		this.pcf8591=pcf8591;
	}
	
	public double getValue() throws Exception{
		int analogVal=pcf8591.analogRead();
		double value = 5*(double)analogVal/255;
		value=10000*value/(5-value);
		value=1/((Math.log(value/10000)/3950)+(1/(273.15+25)));
		value= value-273.15;
		return value;
	}
	
	public static void main(String[] args) throws Exception {
		PCF8591 pcf8591= new PCF8591(0x48, PCF8591.AIN1);
		ThermistorSensor test = new ThermistorSensor(pcf8591);
		while(true){
			double value = test.getValue();
			System.out.println(value+"도");
			Thread.sleep(1000);
		}
	}
	
}
