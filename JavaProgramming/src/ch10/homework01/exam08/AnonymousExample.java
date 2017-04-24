package ch10.homework01.exam08;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		anony.field.turnOn();
		
		anony.method1();
		
		anony.method2(new RemoteControl(){

			@Override
			public void turnOn() {
				System.out.println("스마트 TV를 켭니다. ");
			}

			@Override
			public void turnOff() {
				System.out.println("스마트 TV를 끕니다. ");
			}
			
		});
		
		
	}

}
