package ch06.exam02;

public class Carexample {

	public static void main(String[] args) {
		//��ü �����ڵ�
		Car mycar=new Car();
		System.out.println(mycar.company);
		System.out.println(mycar.speed);
		System.out.println(mycar.color);
		System.out.println(mycar.airback);
		
		Car yourcar = new Car("����",true);
		System.out.println(yourcar.company);
		System.out.println(yourcar.speed);
		System.out.println(yourcar.color);
		System.out.println(yourcar.airback);
		
		yourcar = new Car("����",false);
		System.out.println(yourcar.company);
		System.out.println(yourcar.speed);
		System.out.println(yourcar.color);
		System.out.println(yourcar.airback);
	}

}
