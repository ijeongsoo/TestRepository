package ch05.homework01;

public class WhileKeyControlExample{

	public static void main(String[] args) throws Exception{
		boolean run = true; 	//���Ḧ ���� ���� ����
		int speed =0;
		int keyCode=0;
		
		while(run){
			//������ ��� ���� 
			if(keyCode!=13&&keyCode!=10){
				System.out.println("------------------------");
				System.out.println("1.���� | 2.���� | 3.����");
				System.out.println("------------------------");
				System.out.print("���� :");
			}
			
			//Ű����� �Է� �ޱ� 
			keyCode=System.in.read();
			
			//1�Է������� 
			if(keyCode ==49){
				speed++;
				System.out.println("����ӵ�="+speed);
			}else if(keyCode==50){		//2�Է�������
				speed--;
				System.out.println("����ӵ�="+speed);
			}else if(keyCode==51){		//3�Է�������
				run=false;				//while�� ���Ḧ ����
			}
		}
		
		System.out.println("���α׷�����");
	}

}
