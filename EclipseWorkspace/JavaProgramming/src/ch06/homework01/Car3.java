package ch06.homework01;

public class Car3 {
	//Field
	String company="�����ڵ���";
	String model;
	String color;
	int maxSpeed;
	
	//������ �����ε�
	//�Ű����� �ϳ��� ����
	Car3(){
		
	}
	
	//�Ű����� �Ѱ�
	//this�� ����ؼ� �Ű������� �ʵ尪 ����
	Car3(String model){
		this.model=model;
	}
	
	//�Ű����� �ΰ�
	//this�� ����ؼ� �Ű������� �ʵ尪 ����
	Car3(String model, String color){
		this.model=model;
		this.color=color;
	}
	
	//�Ű����� ����
	//this�� ����ؼ� �Ű������� �ʵ尪 ����
	Car3(String model, String color, int maxSpeed){
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
}
