package ch05.homework01;

public class IfExample {

	public static void main(String[] args) {
		int score =93; 
		
		//score�� 90�̻��̸� ���� �ƴϸ� ���
		if(score>=90){	
			System.out.println("������ 90���� Ů�ϴ�.");
			System.out.println("����� A�Դϴ�.");
		}
		
		//score�� 90�̸��̸� ���� �ƴϸ� ���
		if(score<90)	
			System.out.println("������ 90���� �۽��ϴ�.");
			
		System.out.println("����� B�Դϴ�.");	//if���� ������� ����Ǵ� �κ�
		
	}

}
