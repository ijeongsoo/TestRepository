package ch09.exam07;

public class Example{
	public static void main(String[] args){
		//local class ���� �ϰ� ��ü ����		
		/*A a = new A();
		class B2 extends B{
					
			@Override
			void bMethod() {
				System.out.println("B2�� B�޼ҵ�");
			}
		}
		
		
		A.B b =new B2();
		b.bMethod();
	}*/
		A a = new A();
		A.B b= a.new B(){

			@Override
			void bMethod() {
				// TODO Auto-generated method stub
				
			}
		};
		
	b.bMethod();
	}

}
