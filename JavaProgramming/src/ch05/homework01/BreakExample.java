package ch05.homework01;

public class BreakExample {

	public static void main(String[] args) {
		while(true){
			int num=(int)(Math.random()*6)+1;	//1~6���� ���� �� ����
			System.out.println(num);
			//�������� ���� ���� 6�̸� ���α׷� ����;
			if(num==6){
				break;
			}
		}
		System.out.println("���α׷� ����");
	}

}
