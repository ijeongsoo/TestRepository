package ch06.homework01;

public class Calculator {
	//Field
	
	//Constructor
	
	//Method
	//��ȯ�� ����, �Ű����� ����
	void powerOn(){
		System.out.println("������ �մϴ�.");
	}
	
	//int ��ȯ�� int �Ű�����
	int plus(int x, int y){
		int result=x+y;
		return result;
	}
	
	//double ��ȯ�� 
	double divide(int x, int y){
		//double�� �ֱ� ���ؼ� int�� double�� ����ȯ
		double result =(double)x/(double)y;
		//double�� ��ȯ
		return result;
	}
	
	//��ȯ�� ����, �Ű����� ����
	void powerOff(){
		System.out.println("������ ���ϴ�");
	}
	
}
