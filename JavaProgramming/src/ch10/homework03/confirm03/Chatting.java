package ch10.homework03.confirm03;

public class Chatting {
	void startChat(String chatId){
		String nickName =null;
		//nickName = chatId;		//로컬 변수는 final이므로 변경 할 수 없다. 
		Chat chat = new Chat(){		//익명 클래스 지만 어째튼 로컬 클래스 이다. 
			@Override
			void start() {
				while(true){
					String inputData = "안녕하세요 ";
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
