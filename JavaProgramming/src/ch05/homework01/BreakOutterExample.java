package ch05.homework01;

public class BreakOutterExample {

	public static void main(String[] args) {
		//Outter ���� �� A���� Z���� �ݺ�
		Outter: for(char upper='A'; upper<='Z'; upper++){
			//a���� z���� �ݺ�
			for(char lower='a'; lower<='z'; lower++){
				System.out.println(upper + "-"+lower);
				if(lower=='g'){
					//�ٷ� �� �ݺ����� �ƴ� Outer������ �κ� �ݺ��� ���� 
					break Outter;
				}
			}
		}
		System.out.println("���α׷� ���� ����");
	}

}
