package ch06.homework01;

public class Calculator2 {
	//Field
	
	//Constructor
		
	//Method
	//int ��ȯ�� int �Ű�����
	int plus(int x, int y){
		int result=x+y;
		return result;
	}
	
	//double ��ȯ�� 
	double avg(int x, int y){
		//���� ������ plus�޼ҵ� ȣ��
		double sum = plus(x,y);
		double result =sum/2;
		return result;
	}
	
	void execute(){
		//���� ������ avg�޼ҵ� ȣ�� ->plus�޼ҵ� ȣ��
		double result = avg(7,10);
		//�ؿ� ������ println �޼ҵ� ȣ��
		println("������ : "+result);
	}
	
	void println(String message){
		System.out.println(message);
	}
}
