package ch05.homework01;

public class ContinueExample {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			//2�� ����� �ƴϸ� ��� ���� ����
			if(i%2 != 0){
				continue;
			}
			System.out.println(i);	//2�� ����� ��µ�
		}
	}

}
