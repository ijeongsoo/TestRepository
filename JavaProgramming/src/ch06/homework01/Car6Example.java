package ch06.homework01;

public class Car6Example {

	public static void main(String[] args) {
		Car6 myCar =new Car6();
		//keyTurnOn �޼ҵ� ȣ��
		myCar.keyTurnOn();
		//run �޼ҵ� ȣ��
		myCar.run();
		//getSpeed �޼ҵ� ȣ���� ���ϰ� ������ ����
		int speed = myCar.getSpeed();
		System.out.println("����ӵ�: "+speed+"km/h");
	}

}
