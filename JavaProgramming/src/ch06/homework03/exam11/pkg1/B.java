package ch06.homework03.exam11.pkg1;//A�� ��Ű���� ����. 

public class B {
	public B(){
		A a=new A();
		a.field1=1;	//public�̹Ƿ� ���� ����
		a.field2=1;	//���� ��Ű�� �̹Ƿ� default ���� ����
		//a.field3=1;	//private�̹Ƿ� ���� ��Ű�� ���� ���� �Ұ���
		
		a.method1();	//public�̹Ƿ� ���� ����
		a.method2();	//���� ��Ű�� �̹Ƿ� default ���� ����
		//a.method3();	//private�̹Ƿ� ���� ��Ű�� ���� ���� �Ұ���
	}
}
