package ch05.homework01;

public class SwitchExample {

	public static void main(String[] args) {
		int num =(int)(Math.random()*6)+1;		//1���� 6���� �� �������� ���� ����
		
		//1~6���� �������� ���
		switch(num){
		case 1:
			System.out.println("1���� ���Խ��ϴ�.");
			break;									//�ش����ǿ��� ����
		case 2:
			System.out.println("2���� ���Խ��ϴ�.");
			break;									//�ش����ǿ��� ����
		case 3:
			System.out.println("3���� ���Խ��ϴ�.");
			break;									//�ش����ǿ��� ����
		case 4:
			System.out.println("4���� ���Խ��ϴ�.");
			break;									//�ش����ǿ��� ����
		case 5:
			System.out.println("5���� ���Խ��ϴ�.");
			break;									//�ش����ǿ��� ����
		default:									//���� ������ ��� �ƴϸ�
			System.out.println("6���� ���Խ��ϴ�.");
			break;									//�ش����ǿ��� ����
		}
	}

}
