/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam04.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;

/**
 *
 * @author ijeongsu
 */
public class CoapResource03 extends CoapResource{

	
	//field
	private int value;
	//constructor
	
	public CoapResource03() {
		super("resource03");
		//관찰기능 활성화
		setObservable(true);
		//관찰기능을 제공하다라는 것을 클라이언트가 알수 잇도록 설정 
		getAttributes().setObservable();
		
		//test
		Thread thread = new Thread(){
			@Override
			public void run() {
				int i=0;
				while(true){
					value=i;
					changed();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						Logger.getLogger(CoapResource03.class.getName()).log(Level.SEVERE, null, ex);
					}
					i++;
				}
			}
			
		};
		
		thread.start();
	}
	
	
	
	//method

	@Override
	public void handleGET(CoapExchange exchange) {
		exchange.respond("value="+value);
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
	}
	
	
}
