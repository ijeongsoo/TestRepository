package ch06.exam01;

public class Carexample {

	public static void main(String[] args) {
		//��ü �����ڵ�
		Car mycar=new Car();
		
		//��ü �޼ҵ� ȣ��
		mycar.run();
		
		//��ü�� �ʵ带 �б� 
		System.out.println(mycar.company);
		System.out.println(mycar.speed);
		System.out.println(mycar.color);
		System.out.println(mycar.airback);
		
		//��ü�� �ʵ尪�� ����
		mycar.speed=30;
		mycar.color="���";
		mycar.run();
		System.out.println(mycar.speed);
		System.out.print(mycar.color);
		
		//-------------------------------------
		
		Car yourcar = new Car();
		System.out.println(yourcar.company);
		System.out.print(yourcar.airback);
		System.out.println(yourcar.speed);
		System.out.print(yourcar.color);
	}
	
	public static void test(Car mycar){
		System.out.println(mycar);
	}

}
