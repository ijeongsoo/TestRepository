package ch06.homework02;

public class Arm {
	String location;
	int checkNum=2;

	Arm(String location){
		this.location=location;
	}
	
	void move(int num){
		switch(num){
		case 1: 
			if(checkNum==1){
				System.out.println("�̹� ���� ����ֽ��ϴ�.");
			}else{
				System.out.println(location+"���� ������ϴ�.");
				checkNum=1;
			}
			break;
		case 2:
			if(checkNum==2){
				System.out.println("�̹� ���� ������ �ֽ��ϴ�.");
			}else{
				System.out.println(location+"���� ���Ƚ��ϴ�.");
				checkNum=2;
			}
			
			break;
		}
	}
}
