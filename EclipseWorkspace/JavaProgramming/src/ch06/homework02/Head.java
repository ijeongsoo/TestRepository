package ch06.homework02;

public class Head {
	//Field
	Mouth mouth=new Mouth();
	Eye eye=new Eye();
	Ear []ear={new Ear(), new Ear(), new Ear()};
	
	int checkNum=0;
	//Constructor
	
	//Method
	void bow(int num){
		switch(num){
		case 1: 
			if(checkNum==1){
				System.out.println("�̹� ���� ���� �����Դϴ�.");
			}else{
				System.out.println("���� �������ϴ�.");
				checkNum=num;
			}
			break;
		case 2: 
			if(checkNum==2){
				System.out.println("�̹� ���� �� �����Դϴ�.");
			}else{
				System.out.println("���� ������ϴ�.");
				checkNum=num;
			}
			break;
		case 3:
			if(checkNum==3){
				System.out.println("�̹� ���� ��� ���� �����Դϴ�.");
			}else{
				System.out.println("���� ��� �������ϴ�.");
				checkNum=num;
			}
			break;
		case 4:
			if(checkNum==4){
				System.out.println("�̹� ���� �·� ���� �����Դϴ�.");
			}else{
				System.out.println("���� �·� �������ϴ�.");
				checkNum=num;
			}
			break;
		default :
			if(!(checkNum>=1&&checkNum<=4)){
				System.out.println("�̹� ������ ���� �ֽ��ϴ�.");
			}else{
				System.out.println("���� �������� �մϴ�.");
				checkNum=num;	
			}
			
		}
	}
}
