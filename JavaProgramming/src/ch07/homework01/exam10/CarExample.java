package ch07.homework01.exam10;

public class CarExample {

	public static void main(String[] args) {
		Car car=new Car();
		for(int i=1; i<=5; i++){
			int problemLocation = car.run();
			
			switch(problemLocation){
			case 1:
				System.out.println("�� ���� HankookTire�� ��ü");
				car.frontLeftTire=new HankookTire("�տ���", 15);
				break;
			case 2:
				System.out.println("�� ������ KKumhoTire�� ��ü");
				car.frontRightTire=new KKumhoTire("�տ�����", 13);
				break;
			case 3:
				System.out.println("�� ���� HankookTire�� ��ü");
				car.backLeftTire=new HankookTire("�ڿ���", 14);
				break;
			case 4:
				System.out.println("�� ���� KKumhoookTire�� ��ü");
				car.backRightTire=new KKumhoTire("�ڿ�����", 17);
				break;
			}
			
		}
	}

}
