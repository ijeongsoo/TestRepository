package ch06.homework03.exam11.pkg1;	//BŬ������ ��Ű���� ����. 

//default ��������
public class A {
	//Field
	public int field1; 	//public ���� ����
	int field2;			//default ���� ����
	private int field3;	//private ���� ����
	
	//Constructor
	public A(){
		field1=1;
		field2=1;		//ȣ���ϸ� ���ο��� ����ϹǷ� ������ ���� �ʴ´�. 
		field3=1;
		
		method1();
		method2();
		method3();
	}
	
	//Method
	public void method1(){			//public ���� ����
		
	}
	void method2(){					//default ��������
		
	}
	
	private void method3(){			//private ��������
		
	}
	
	
}
