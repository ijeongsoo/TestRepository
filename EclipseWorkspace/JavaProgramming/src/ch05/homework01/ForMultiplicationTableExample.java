package ch05.homework01;

public class ForMultiplicationTableExample {

	public static void main(String[] args) {
		//2�ܺ��� 9�ܱ��� ���, 2�� for��
		for(int m=2; m<=9; m++){
			System.out.println("*** " + m + "�� ***");
			//1���� 9���� ��
			for(int n=1; n<=9; n++){
				System.out.println(m + "X"+n+" = "+(m*n));
			}
		}
	}

}
