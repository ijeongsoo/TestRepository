package ch10.homework03.confirm02;

public class Anonymous {
	Vehicle field = new Vehicle(){
		@Override
		public void run() {
			System.out.println("�����Ű� �޸��ϴ�. ");
			
		}
	};
	
	void method1(){
		Vehicle localVal = new Vehicle(){

			@Override
			public void run() {
				System.out.println("�¿����� �޸��ϴ�. ");
			}
			
		};
		
		localVal.run();
	}
	
	void method2(Vehicle v){
		v.run();
	}
}
