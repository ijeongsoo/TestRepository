package ch06.homework03.exam04;

public class Singleton {
	//Field
	//��ü ���� ���������� �����ϹǷ� �ٱ����� new���� �ʾƵ� ��ü ���� , private�� ���� ���ϰ� ����
	private static Singleton singleton=new Singleton();
	
	//Constructor
	//�ܺο��� ������ ȣ�� �Ҽ� ���� private
	private Singleton(){
		
	}
	
	//Method
	//�޼ҵ带 �̿��ؼ� ��ü �ּҰ��� �������� �ֵ���
	static Singleton getInstance(){
		return singleton;
	}
	
}
