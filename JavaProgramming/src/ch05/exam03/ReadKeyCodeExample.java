package ch05.exam03;

import java.io.IOException;

public class ReadKeyCodeExample {

	public static void main(String[] args) throws Exception {
		System.out.println("----------------------------");
		System.out.println("1. ���� | 2. �б� | 3. ����");
		System.out.println("----------------------------");
		
		//int keycode=0;
		while(true){
			int keycode=0;
			if(keycode!=13&&keycode!=10){
				System.out.print("��ȣ����:");
			}
			keycode =System.in.read();
			//System.out.println(keycode);
			switch(keycode){
			case 49:
				System.out.println("���弱��");
				break;
			case 50:
				System.out.println("�б⼱��");
				break;
			case 51:
				System.out.println("���ἱ��");
				//return;		//main�� ���������ν� ���� 
				System.exit(0);		//jvm�����Ŵ 
			}
		}
		
	}

}
