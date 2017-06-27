/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensingcar.coap.server.resource;

import hardware.lcd.LCD1602;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ijeongsu
 */
public class LcdResource extends CoapResource {

	private static final Logger logger = LoggerFactory.getLogger(LcdResource.class);
	//field
	private LCD1602 lcd;
	private String currentLine0;
	private String currentLine1;

	//constructor
	public LcdResource() throws Exception {
		super("lcd");
		lcd = new LCD1602(0x27);
		setText("RPI-8-2", getIPaddress());

	}

	//method
	private void setText(String line0, String line1) {
		lcd.clear();
		lcd.write(0, 0, line0);
		lcd.write(1, 0, line1);
		currentLine0 = line0;
		currentLine1 = line1;
	}

	@Override
	public void handleGET(CoapExchange exchange) {
	}

	@Override
	public void handlePOST(CoapExchange exchange) {
		//{"command":"change", "line0":"xx", "line1":"xx"}
		//{"command":"status"}

		try {
			String requestJson = exchange.getRequestText();
			JSONObject requestJsonObject = new JSONObject(requestJson);
			String command = requestJsonObject.getString("command");
			if (command.equals("change")) {
				String line0 = requestJsonObject.getString("line0");
				String line1 = requestJsonObject.getString("line1");
				setText(line0, line1);
			} else if (command.equals("status")) {

			}

			JSONObject responseJsonObject = new JSONObject();
			responseJsonObject.put("result", "success");
			responseJsonObject.put("line0", currentLine0);
			responseJsonObject.put("line1", currentLine1);
			String responseJson = responseJsonObject.toString();

			exchange.respond(responseJson);
		} catch (Exception e) {
			logger.info(e.toString());
			JSONObject responseJsonObject = new JSONObject();
			responseJsonObject.put("result", "fail");

			String responseJson = responseJsonObject.toString();

			exchange.respond(responseJson);
		}
	}

	public static String getIPaddress() throws Exception {
		String wlan0 = "";
		Enumeration<NetworkInterface> niEnum = NetworkInterface.getNetworkInterfaces();
		while (niEnum.hasMoreElements()) {
			NetworkInterface ni = niEnum.nextElement();
			String displayName = ni.getDisplayName();
			if (displayName.equals("wlan0")) {
				Enumeration<InetAddress> iaEnum = ni.getInetAddresses();
				while (iaEnum.hasMoreElements()) {
					InetAddress ia = iaEnum.nextElement();
					if (ia instanceof Inet4Address) {
						wlan0 = ia.getHostAddress();
					}
				}
			}
			
		}
		return wlan0;

	}
}
