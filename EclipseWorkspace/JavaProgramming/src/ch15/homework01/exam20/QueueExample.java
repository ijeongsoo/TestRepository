package ch15.homework01.exam20;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<>();
		
		messageQueue.offer(new Message("sendMail", "ȫ�浿"));
		messageQueue.offer(new Message("sendSNS", "�ſ��"));
		messageQueue.offer(new Message("sendKaKao", "ȫ�α�"));
		
		while(!messageQueue.isEmpty()){
			Message message =messageQueue.poll();
			switch(message.command){
			case "sendMail" :
				System.out.println(message.to+"�Կ��� ������ �����ϴ�.");
				break;
			case "sendSNS" :
				System.out.println(message.to+"�Կ��� SNS�� �����ϴ�.");
				break;
			case "sendKaKao" :
				System.out.println(message.to+"�Կ��� īī������ �����ϴ�.");
				break;
			}
		}
	}

}
