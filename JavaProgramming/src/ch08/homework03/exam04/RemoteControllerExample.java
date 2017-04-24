package ch08.homework03.exam04;

public class RemoteControllerExample {

	public static void main(String[] args) {
		RemoteControl rc=null;
		
		rc=new Television();
		
		rc.turnOn();
		rc.turnOff();
		
		rc=new Audio();
		rc.turnOn();
		rc.turnOff();
	}

}
