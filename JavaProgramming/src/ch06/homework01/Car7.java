package ch06.homework01;

public class Car7 {
	//Field
	String model;
	int speed;
	
	//Constructor
	//this�� ���� �Ű����� �ʵ尪�� ����
	Car7(String model){
		this.model=model;
	}
	
	//Method
	//this�� ���� �Ű������� �ʵ尪�� ����
	void setSpeed(int speed){
		this.speed=speed;
	}
	
	void run(){
		for(int i=10; i<=50; i+=10){
			//this�� �̿��Ͽ� ���� Ŭ������ �޼ҵ� ���
			this.setSpeed(i);;
			//this�� ���� ���� Ŭ���� �ʵ尪 ���
			System.out.println(this.model +"�� �޸��ϴ�.(�ü�:"+this.speed+"km/h)");
		}
	}
}
