package ch06.homework01;

public class Car4 {
	//Field
	String company="�����ڵ���";
	String model;
	String color;
	int maxSpeed;
	
	//Construct
	//������ �����ε�
	//�Ű����� 0��
	Car4(){
		
	}
	//�Ű����� 3��¥�� ������ ȣ��
	Car4(String model){
		this(model, "����", 250);
	}
	
	//�Ű����� 3��¥�� ������ ȣ��
	Car4(String model, String color){
		this(model, color, 250);
	}
	
	Car4(String model, String color, int maxSpeed){
		//���� ���� ����
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
}
