package ch06.exam01;

public class Car {
	//Field : ��ü�� �������� ������ �κ�
	String company="�����ڵ���";		//���赵 �� ������ �ʿ�� ����. �ٲ���� �ִ�. 
	int speed;						//��� ���� ������ �𸣸� �����
	String color;
	boolean airback;
	
	//Constructor
	Car(){
		//��ü�� ���鶧 ��ü�� ��� ������ �ȴٴ� ����
		color="���";
		airback=true;
	}
	
	//Method
	void run(){
		System.out.println("���� "+ speed + "km/h�� �޸��ϴ�.");
	}
	
}
