package ch05.homework01;

public class ForSumFrom1To100Example2 {

	public static void main(String[] args) {
		int sum=0;	//���Ѱ� ���� ���� ����
		int i=0; //ī���� ����
		//1���� 100���� ���ϱ�
		for(i=1; i<=100; i++){
			sum+=i;
		}
		
		//���� �� ���, ī��Ʈ�� i�� ���
		System.out.println("1~"+(i-1)+" ��: "+ sum);
	}

}
