package ch06.exam02;

public class Car {
	//Field : ��ü�� �������� ������ �κ�
	String company="�����ڵ���";		//���赵 �� ������ �ʿ�� ����. �ٲ���� �ִ�. 
	int speed;						//��� ���� ������ �𸣸� �����
	String color;
	boolean airback;
	
	//Constructor
	Car(){
		//��ü�� ���鶧 ��ü�� ��� ������ �ȴٴ� ����
		this("�����ڵ���", null, false);
	}
	
	Car(String color, boolean airback){
		 this("�����ڵ���", color, airback);
	}
	
	Car(String company, String color, boolean airback){
		this.company=company;
		this.color=color;
		this.airback=airback;
	}
	
	//Method
	void run(){
		System.out.println("���� "+ speed + "km/h�� �޸��ϴ�.");
	}
	
}
