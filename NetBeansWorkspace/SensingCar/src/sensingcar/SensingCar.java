/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sensingcar.coap.server.CoapResourceServer;

/**
 *
 * @author ijeongsu
 */
public class SensingCar {
	
	//field
	private static final Logger logger = LoggerFactory.getLogger(SensingCar.class);
	private CoapResourceServer coapResourceServer;
	//constructor

	public SensingCar() {
		coapResourceServer= new CoapResourceServer();
	}
	
	//method 
	
	public void start(){
		logger.info("실행");
		coapResourceServer.start();
		System.out.println("SensingCar Start...");
	}
	
	public void stop(){
		logger.info("정지");
		coapResourceServer.stop();
		System.out.println("SensingCar stop...");
	}
	
	public static void main(String[] args) {
		SensingCar sensingCar = new SensingCar();
		sensingCar.start();
		
		System.out.print("input command('q' to quit):");
		Scanner scanner = new Scanner(System.in);
		
		String command = scanner.nextLine();
		if(command.equals("q")){
			sensingCar.stop();
		}
	}
}
