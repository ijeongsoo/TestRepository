package ch06.homework03.exam11.pkg2;//A�� B�� ��Ű���� �ٸ���

import ch06.homework03.exam11.pkg1.A;

public class C {
	public C(){
		A a=new A();
		a.field1=1;	//public�̹Ƿ� ���� ����
		//a.field2=1;	//���� ��Ű���� �ƴϹǷ� default ���� �Ұ���
		//a.field3=1;	//private�̹Ƿ� ���� ��Ű�� ���� ���� �Ұ���
		
		a.method1();	//public�̹Ƿ� ���� ����
		//a.method2();	//���� ��Ű����  �ƴϹǷ� default ���� �Ұ���
		//a.method3();	//private�̹Ƿ� ���� ��Ű�� ���� ���� �Ұ���
	}
}
