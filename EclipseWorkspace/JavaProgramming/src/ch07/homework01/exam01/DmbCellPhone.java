package ch07.homework01.exam01;

public class DmbCellPhone extends CellPhone{
	//Field
	int channel;
	
	//Constructor
	DmbCellPhone(String model, String color, int channel){
		this.model=model;
		this.color=color;
		this.channel=channel;
	}
	
	//Method
	void turnOnDmb(){
		System.out.println("ä��"+channel+"�� DMB ��� ������ �����մϴ�.");
	}
	
	void changeChannelDmb(int channel){
		this.channel=channel;
		System.out.println("ä��"+channel+"�� ���� �ٲߴϴ�.");
	}
	
	void turnOffDmb(){
		System.out.println("DMB ��� ������ ����ϴ�.");
	}
}
