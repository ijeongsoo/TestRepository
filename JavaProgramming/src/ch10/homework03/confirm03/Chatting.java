package ch10.homework03.confirm03;

public class Chatting {
	void startChat(String chatId){
		String nickName =null;
		//nickName = chatId;		//���� ������ final�̹Ƿ� ���� �� �� ����. 
		Chat chat = new Chat(){		//�͸� Ŭ���� ���� ��°ư ���� Ŭ���� �̴�. 
			@Override
			void start() {
				while(true){
					String inputData = "�ȳ��ϼ��� ";
					String message = "["+nickName +"]" +inputData;
					sendMessage(message);
				}
			}
		};
		
		chat.start();
	}
	
	class Chat{
		void start(){
			
		}
		void sendMessage(String message){
			
		}
	}
}
