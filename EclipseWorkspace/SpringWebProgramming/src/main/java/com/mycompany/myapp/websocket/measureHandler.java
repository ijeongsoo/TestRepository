package com.mycompany.myapp.websocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class measureHandler extends TextWebSocketHandler {
	private static final Logger logger = LoggerFactory.getLogger(measureHandler.class);

	private List<WebSocketSession> list = new Vector<>();

	@PostConstruct
	public void init() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				int temperature = 0;
				while (true) {
					try {
						for (WebSocketSession session : list) {
							session.sendMessage(new TextMessage(String.valueOf(++temperature)));
						}
						Thread.sleep(1000);
					} catch (Exception e) {
					}

				}
			}
		};
		
		thread.start();
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("");
		list.add(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("");
		list.remove(session);
	}
}
