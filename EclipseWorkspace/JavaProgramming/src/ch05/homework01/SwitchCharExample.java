package ch05.homework01;

public class SwitchCharExample {

	public static void main(String[] args) {
		char grade='B';
		
		//char�� ��쵵 ����ġ ����
		switch(grade){
		//A�Ǵ� a�� ���
		case 'A':
		case 'a':
			System.out.println("���ȸ���Դϴ�.");
			break;
		//B�Ǵ� b�� ���
		case 'B':
		case 'b':
			System.out.println("�Ϲ�ȸ���Դϴ�.");
			break;
		//���� ���ǰ� �ƹ��͵� ���� �������
		default:
			System.out.println("�մ��Դϴ�.");
		}
	}

}
