package ch05.homework01;

public class IfNestedExample {

	public static void main(String[] args) {
		int score=(int)(Math.random()*20)+81;	//81~100���� ���� ������ ���� , ����ȯ

		//�������� ���� ���� ���
		System.out.println("����: "+ score);
		
		String grade;
		
		if(score>=90){			//��ø if������ 95�̻��̸� A+ 90�̻� 95�̸� �̸� A
			if(score>=95){
				grade="A+";
			}else{
				grade="A";
			}
		}else{					//��ø if������ 90�̸� 85�̻��̸� B+ 80�̻� 85�̸� �̸� B
			if(score>=85){
				grade="B+";
			}else{
				grade="B";
			}
		}
		
		System.out.println("����: "+ grade);
	}

}
