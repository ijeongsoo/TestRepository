package ch06.homework01;

public class Calculator3Example {

	public static void main(String[] args) {
		//��ü ����
		Calculator3 myCalcu = new Calculator3();
		
		//���� ���̰� 10�� ���簢�� ũ�� ���ϱ�
		double result1=myCalcu.areaRectangle(10);
		
		//���簢�� ���� ���ϱ� 
		double result2=myCalcu.areaRectangle(10, 20);
		
		System.out.println("���簢�� ����="+result1);
		System.out.println("���簢�� ����="+result2);
	}

}
