package ch06.homework03.exam04;

public class SingletonExample {

	public static void main(String[] args) {
		/*
		 Singleton obj1 =new Singleton();	//�����ڿ� ���� �Ҽ� ���� ������ ���� �Ұ���
		 */
		
		//�ΰ��� ��� ���� ��ü�� ����Ų��. 
		Singleton obj1=Singleton.getInstance();
		Singleton obj2=Singleton.getInstance();
		
		if(obj1 ==obj2){
			System.out.println("������ü");
		}else{
			System.out.println("�ٸ���ü");
		}
	}

}
