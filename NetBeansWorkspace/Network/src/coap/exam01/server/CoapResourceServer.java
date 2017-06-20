/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam01.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.network.CoapEndpoint;

/**
 *
 * @author ijeongsu
 */
public class CoapResourceServer {
	//field
	private CoapServer coapServer;
	
	//constructor
	public CoapResourceServer(){
		coapServer = new CoapServer();
		InetSocketAddress isa = new InetSocketAddress("192.168.3.36", 5683);
		coapServer.addEndpoint(new CoapEndpoint(isa));
		coapServer.add(new CoapResource01());
		coapServer.start();
	}
	//method
	public void shutdown(){
		coapServer.stop();
		coapServer.destroy();
	}
	
	public static void main(String[] args) throws IOException{
		CoapResourceServer server = new CoapResourceServer();
		System.out.println("CoAP Server is listening on port 5683");
		
		System.in.read();
		server.shutdown();
	}
}