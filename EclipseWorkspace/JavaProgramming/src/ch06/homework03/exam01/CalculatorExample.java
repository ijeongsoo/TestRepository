package ch06.homework03.exam01;

public class CalculatorExample {

	public static void main(String[] args) {
		//pi���� static�̹Ƿ� ��ü���� ���ϰ� ��밡��
		double result1=10*10*Calculator.pi;
		//plus�޼ҵ�� static�̹Ƿ� ��ü ���� ���ϰ� ��밡��
		int result2=Calculator.plus(10, 5);
		//minus�޼ҵ�� static�̹Ƿ� ��ü ���� ���ϰ� ��밡��
		int result3=Calculator.minus(10, 5);
		
		System.out.println("result1:"+result1);
		System.out.println("result2:"+result2);
		System.out.println("result3:"+result3);
	}

}
