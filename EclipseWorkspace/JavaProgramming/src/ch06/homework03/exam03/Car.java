package ch06.homework03.exam03;


public class Car {
		//�ν��Ͻ� �ʵ�
		int speed;
		//�ν��Ͻ� �޼ҵ� 
		void run(){
			System.out.println(speed+"���� �޸��ϴ�.");
		}
		
		//main �޼ҵ�� ���� �޼ҵ� �̴�. 
		public static void main(String[] args){
			//�����޼ҿ��� �ν��Ͻ� �ʵ�� �޼ҵ带 ����ϱ� ���ؼ��� ��ü ������ ����ؾ� �Ѵ�. 
			Car myCar=new Car();
			myCar.speed=60;
			myCar.run();
		}
}
