package ch15.homework01.exam09;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashtableExample {

	public static void main(String[] args) {
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			System.out.println("���̵�� ��й�ȣ�� �Է��� �ּ���");
			System.out.print("���̵�:");
			String id=scanner.nextLine();
			System.out.print("��й�ȣ:");
			String pw=scanner.nextLine();
			System.out.println();
			
			if(map.containsKey(id)){
				if(map.get(id).equals(pw)){
					System.out.println("�α��� �Ǿ����ϴ�.");
				}else{
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. ");
				}
			}else{
				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�.");
			}
		}
	}

}
