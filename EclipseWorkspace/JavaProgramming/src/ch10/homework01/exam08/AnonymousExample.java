package ch10.homework01.exam08;

public class AnonymousExample {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		anony.field.turnOn();
		
		anony.method1();
		
		anony.method2(new RemoteControl(){

			@Override
			public void turnOn() {
				System.out.println("����Ʈ TV�� �մϴ�. ");
			}

			@Override
			public void turnOff() {
				System.out.println("����Ʈ TV�� ���ϴ�. ");
			}
			
		});
		
		
	}

}
