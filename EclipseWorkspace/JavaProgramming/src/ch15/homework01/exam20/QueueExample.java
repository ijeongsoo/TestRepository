package ch15.homework01.exam20;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("sendMail", "È«±æµ¿"));
		messageQueue.offer(new Message("sendSNS", "½Å¿ë±Ç"));
		messageQueue.offer(new Message("sendKaKao", "È«µÎ±ú"));
		
		while(!messageQueue.isEmpty()){
			Message message =messageQueue.poll();
			switch(message.command){
			case "sendMail" :
				System.out.println(message.to+"´Ô¿¡°Ô ¸ÞÀÏÀ» º¸³À´Ï´Ù.");
				break;
			case "sendSNS" :
				System.out.println(message.to+"´Ô¿¡°Ô SNSÀ» º¸³À´Ï´Ù.");
				break;
			case "sendKaKao" :
				System.out.println(message.to+"´Ô¿¡°Ô Ä«Ä«¿ÀÅåÀ» º¸³À´Ï´Ù.");
				break;
			}
		}
	}

}
