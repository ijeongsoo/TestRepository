package ch06.homework03.exam12;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		//�߸��� �ӵ� ����
		myCar.setSpeed(-50);
		
		System.out.println("����ӵ�:"+myCar.getSpeed());
		
		//�ùٸ� �ӵ� ����
		myCar.setSpeed(60);
		
		//���� �޸��� ������ ���߰� �ϴ� �ڵ�
		if(!myCar.isStop()){
			myCar.setStop(true);
		}
		
		//����� ������ �ӵ��� 0
		System.out.println("����ӵ�:"+myCar.getSpeed());
	}

}
