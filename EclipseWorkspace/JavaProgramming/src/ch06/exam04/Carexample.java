package ch06.exam04;


public class Carexample {

	public static void main(String[] args) {
		//��ü ����
		Car myCar = new Car("2017-03-28", "����");
		//���� �޼ҵ� �۵�
		myCar.engine.start();
		myCar.engine.stop();
		//Dashboard�� �޼ҵ� ȣ��
		myCar.dashboard.display(60);
		//Ÿ�̾��� �ʵ尪 �б� 
		System.out.println(myCar.tires[0].location) ;
		//Ÿ�̾��� �޼ҵ� ȣ��
		myCar.tires[2].roll();
		//car�� �޼ҵ� ȣ��
		myCar.start();
		myCar.run();
		myCar.stop();
		
		//-------------------------------------
		//Tire ��ǰ��ü 
		myCar.tires[0]=new Tire("�� ��1�� ����");
		myCar.run();
	}

}
