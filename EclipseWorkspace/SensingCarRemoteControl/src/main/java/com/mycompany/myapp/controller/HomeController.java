package com.mycompany.myapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model, HttpServletResponse response) {
		CoapClient coapClient = new CoapClient();
		JSONObject jsonObject = null;
		String json = null;
		CoapResponse coapResponse = null;

		// -----------------------------------------------------------------------
		// 카메라
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/camera");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("leftRight", jsonObject.getString("leftRight"));
		model.addAttribute("upDown", jsonObject.getString("upDown"));

		// ------------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/rgbled");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("red", jsonObject.getString("red"));
		model.addAttribute("green", jsonObject.getString("green"));
		model.addAttribute("blue", jsonObject.getString("blue"));

		// ------------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/laseremitter");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("laserEmitterStatus", jsonObject.getString("status"));

		// ------------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/buzzer");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("buzzerStatus", jsonObject.getString("status"));

		// ------------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/ultrasonicsensor");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("ultrasonicSensorAngle", jsonObject.getString("angle"));
		model.addAttribute("distance", jsonObject.getString("distance"));

		// ------------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/lcd");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("lcdLine0", jsonObject.getString("line0"));
		model.addAttribute("lcdLine1", jsonObject.getString("line1"));

		// ------------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/fronttire");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("frontTireAngle", jsonObject.getString("angle"));

		// -----------------------------------------------------------------------
		jsonObject = new JSONObject();
		jsonObject.put("command", "status");
		json = jsonObject.toString();
		coapClient.setURI("coap://192.168.3.36/backtire");
		coapResponse = coapClient.post(json, MediaTypeRegistry.APPLICATION_JSON);
		json = coapResponse.getResponseText();
		jsonObject = new JSONObject(json);
		model.addAttribute("backTireSpeed", jsonObject.getString("speed"));
		model.addAttribute("backTireDirection", jsonObject.getString("direction"));
		
		

		coapClient.shutdown();

		model.addAttribute("cameraUrl", "http://192.168.3.36:50001?action=stream");

		return "controlpanel";
	}

	@RequestMapping("/camera")
	public void camera(String command, String leftRight, String upDown, HttpServletResponse response)
			throws IOException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("leftRight", leftRight);
		jsonObject.put("upDown", upDown);
		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/camera");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();

	}

	@RequestMapping("/rgbLed")
	public void rgbLed(String command, String red, String green, String blue, HttpServletResponse response)
			throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("red", red);
		jsonObject.put("green", green);
		jsonObject.put("blue", blue);
		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/rgbled");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/laserEmitter")
	public void laserEmitter(String command, String status, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("status", status);

		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/laseremitter");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/buzzer")
	public void buzzer(String command, String status, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("status", status);

		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/buzzer");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/ultrasonicSensor")
	public void ultrasonicSensor(String command, String angle, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("angle", angle);

		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/ultrasonicsensor");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/lcd")
	public void lcd(String command, String line0, String line1, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("line0", line0);
		jsonObject.put("line1", line1);

		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/lcd");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}

	@RequestMapping("/frontTire")
	public void frontTire(String command, String angle, HttpServletResponse response) throws IOException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("angle", angle);

		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/fronttire");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();
	}
	
	@RequestMapping("/backTire")
	public void backTire(String command, String direction, String speed, HttpServletResponse response)
			throws IOException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("command", command);
		jsonObject.put("direction", direction);
		jsonObject.put("speed", speed);
		String reqJson = jsonObject.toString();

		CoapClient coapClient = new CoapClient();
		coapClient.setURI("coap://192.168.3.36/backtire");
		CoapResponse coapResponse = coapClient.post(reqJson, MediaTypeRegistry.APPLICATION_JSON);
		String resJson = coapResponse.getResponseText();

		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		coapClient.shutdown();
		pw.write(resJson);
		pw.flush();
		pw.close();

	}

}
