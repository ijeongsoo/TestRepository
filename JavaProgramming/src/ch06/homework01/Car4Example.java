package ch06.homework01;

public class Car4Example {

	public static void main(String[] args) {
		Car4 car1=new Car4();
		System.out.println("car1.company:"+car1.company);
		System.out.println();
	
		//2��° ������ �̿��ؼ� ��ü ����, �Ű����� 1��->�ᱹ �Ű����� 3��¥�� ������ ��
		Car4 car2=new Car4("�ڰ���");
		System.out.println("car2.company:"+car2.company);
		System.out.println("car2.model:"+car2.model);
		System.out.println();
		
		//3��° ������ �̿��ؼ� ��ü ����, �Ű����� 2��->�ᱹ �Ű����� 3��¥�� ������ ��
		Car4 car3=new Car4("�ڰ���", "����");
		System.out.println("car3.company:"+car3.company);
		System.out.println("car3.model:"+car3.model);
		System.out.println("car3.color:"+car3.color);
		System.out.println();
		
		//4��° ������ �̿��ؼ� ��ü ����, �Ű����� 3��
		Car4 car4=new Car4("�ý�", "����", 200);
		System.out.println("car4.company:"+car4.company);
		System.out.println("car4.model:"+car4.model);
		System.out.println("car4.color:"+car4.color);
		System.out.println("car4.maxSpeed:"+car4.maxSpeed);
	}

}
