package ch05.homework01;

public class IfElseIfElseExample {

	public static void main(String[] args) {
		int score =75;
		
		//90�̻��̸� ����Ǵ� �κ�
		if(score>=90){
			System.out.println("������ 100~90�Դϴ�.");
			System.out.println("����� A�Դϴ�.");
		}else if(score>=80){	//80�̻��̸� ����Ǵ� �κ�
			System.out.println("������ 80~89 �Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		}else if(score>=70){	//70�̻��̸� ����Ǵ� �κ�
			System.out.println("������ 70~79 �Դϴ�.");
			System.out.println("����� C�Դϴ�.");
		}else{					//70�̸��� ��� ����Ǵ� �κ�
			System.out.println("������ 70�̸� �Դϴ�.");
			System.out.println("����� D�Դϴ�.");
		}
	}

}
