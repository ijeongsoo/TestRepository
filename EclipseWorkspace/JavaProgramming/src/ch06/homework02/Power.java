package ch06.homework02;

public class Power {
	//Field
	
	//Constructor
	
	//Method
	void start() throws Exception{
		int power=0;
		while(power!=10){
			power=System.in.read();
		}
		System.out.println("������ �������ϴ�.");
	}
	void stop() {
		System.out.println("������ �����ϴ�.");
		System.exit(0);
	}
}
