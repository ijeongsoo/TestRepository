package ch05.homework01;

//Scanner Ŭ������ ����ϱ� ���� �ʿ�
import java.util.Scanner;
public class DoWhileExample {

	public static void main(String[] args) {
		System.out.println("�޽����� �Է��ϼ���");
		System.out.println("���α׷��� �����Ϸ��� q�� �Է��ϼ���.");
		
		Scanner scanner=new Scanner(System.in);	//��ĳ�� ��ü ����
		String inputString;
		
		//�켱 �ѹ��� ����, q�Է� ���������� �Է¹��� ���� ���
		do{
			System.out.print(">");
			//��Ʈ�� ������ ��ĳ�� ��ü�� nextLine()�޼ҵ带 �̿��ؼ� ���ڿ� �Է� 
			inputString = scanner.nextLine();
			System.out.println(inputString);
		}while(!inputString.equals("q"));
		
		System.out.println();
		System.out.println("���α׷� ����");
	}

}
