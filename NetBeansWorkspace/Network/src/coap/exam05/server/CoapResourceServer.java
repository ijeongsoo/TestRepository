/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coap.exam05.server;

import coap.exam04.server.*;
import coap.exam02.server.*;
import coap.exam01.server.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.network.CoapEndpoint;
import org.eclipse.californium.core.network.EndpointManager;
import org.eclipse.californium.proxy.DirectProxyCoapResolver;
import org.eclipse.californium.proxy.ProxyHttpServer;
import org.eclipse.californium.proxy.resources.ForwardingResource;
import org.eclipse.californium.proxy.resources.ProxyCoapClientResource;

/**
 *
 * @author ijeongsu
 */
public class CoapResourceServer {

	//field
	private CoapServer coapServer;

	//constructor
	public CoapResourceServer() throws Exception {
		coapServer = new CoapServer();
		
		for (InetAddress addr : EndpointManager.getEndpointManager().getNetworkInterfaces()) {
			if (!addr.isLinkLocalAddress()) {
				coapServer.addEndpoint(new CoapEndpoint(new InetSocketAddress(addr, CoAP.DEFAULT_COAP_PORT)));
			}
		}
		
		coapServer.add(new CoapResource01());
		coapServer.add(new CoapResource02());
		coapServer.add(new CoapResource03());
		coapServer.add(new CoapResource04());
		coapServer.add(new CoapResource05());
		coapServer.add(new CoapResource06());

		//coap -> coap 포워드 프록시 설정 
		ForwardingResource coap2coap = new ProxyCoapClientResource("coap2coap");
		coapServer.add(coap2coap);
		
		//http ->coap 포워드 프록시 설정 
		ProxyHttpServer httpServer = new ProxyHttpServer(9090);
		httpServer.setProxyCoapResolver(new DirectProxyCoapResolver(coap2coap));
		

		coapServer.start();
	}

	//method
	public void shutdown() {
		coapServer.stop();
		coapServer.destroy();
	}

	public static void main(String[] args) throws IOException, Exception {
		CoapResourceServer server = new CoapResourceServer();
		System.out.println("CoAP Server is listening on port 5683");

		System.in.read();
		server.shutdown();
	}
}
