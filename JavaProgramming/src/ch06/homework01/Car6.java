package ch06.homework01;

public class Car6 {
	//Field
	int speed;
	
	//Constructor
	
	//Method
	//speed�ʵ尪 ��ȯ
	int getSpeed(){
		return speed;
	}
	
	
	void keyTurnOn(){
		System.out.println("Ű�� �����ϴ�.");
	}
	
	//�ü� ����
	void run(){
		for(int i=10; i<=50; i+=10){
			speed=i;
			System.out.println("�޸��ϴ�.(�ü�:" +speed + "km/h)");
		}
	}
	
}
