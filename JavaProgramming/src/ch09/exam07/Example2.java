package ch09.exam07;

public class Example2{
	public static void main(String[] args){
		//local class�� �����ϰ� ��ü ����
		/*class Cimpl implements A.C{

			@Override
			public void cMethod() {
				System.out.println("Cimple-cMethod()");
			}
			
		}
		
		A.C c = new Cimpl();
		
		c.cMethod();*/
		
		A.C c = new A.C(){

			@Override
			public void cMethod() {
				System.out.println("Cimple-cMethod()");
			}
			
		};
		
		c.cMethod();
	}

}
