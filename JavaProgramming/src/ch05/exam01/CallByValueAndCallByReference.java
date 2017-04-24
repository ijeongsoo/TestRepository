package ch05.exam01;

public class CallByValueAndCallByReference {
	public static void main(String[] args) {
		//�޼ҵ� ����ҷ��� ȣ�� �ؾ���
		int v1=10;
		int v2=20;
		int v3=sum(v1,v2);	//call by value
		System.out.println("v1:" + v1);	//�ڹٿ��� ����ϴ� ���, +�� ��������� �Ҽ��� �ְ� ���ڿ� ���ձ�ɵ� ������ �ִ�.
		System.out.println("v2:" + v2);
		System.out.println("v3:" + v3);
		
		
		int[] v4={10, 20};
		int v5= sum(v4);
		System.out.println("v4[0]:" + v4[0]);	//�ڹٿ��� ����ϴ� ���, +�� ��������� �Ҽ��� �ְ� ���ڿ� ���ձ�ɵ� ������ �ִ�.
		System.out.println("v4[1]:" + v4[1]);
		System.out.println("v5:" + v5);
		
	}
	
	public static int sum(int x, int y){//�������� �Ű����� ��
		x=30;
		y=40;
		
		return x+y;
	}
	
	public static int sum(int[] scores){	//�������� �Ű����� ��		
		scores[0]=30;
		scores[1]=40;
		
		int sum =0;
		for(int i=0; i<scores.length; i++){
			sum += scores[i];
		}
		return sum;
	}
}
