package ch06.exam03;

public class Calculator {
	//Field
	
	//Constructor
	
	//Method
	void powerOn(){
		System.out.println("������ ŵ�ϴ�.");
	}
	
	void powerOff(){
		System.out.println("������ ���ϴ�.");
	}
	
	String info(){
		return "�Ｚ����-2012-03-28";
	}
	
	int plus(int x, int y){
		int result = x+y;
		return result;
	}
	
	double plus(double x, double y){
		double result = x+y;
		return result;
	}
	
	double divide(double x, double y){
		double result =x/y;
		return result;
	}
	
	int[] changeArray(int x, int y, int z){
		int [] array={x, y, z};
		return array;
	}
	
	Car makeCar(String color, boolean airback){
		Car mycar = new Car(color, airback);
		return mycar;
	}
}
