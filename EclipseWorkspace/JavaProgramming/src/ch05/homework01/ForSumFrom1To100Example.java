package ch05.homework01;

public class ForSumFrom1To100Example {

	public static void main(String[] args) {
		int sum=0;	//���Ѱ� ���� ���� ����
		
		//1���� 100���� ���ϱ�
		for(int i=1; i<=100; i++){
			sum+=i;
		}
		
		//���� �� ���
		System.out.println("1~100 �� :"+ sum);
	}

}
