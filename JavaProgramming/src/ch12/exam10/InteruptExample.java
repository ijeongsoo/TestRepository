package ch12.exam10;

public class InteruptExample {

	public static void main(String[] args) {
		
		//How2
		PrintThread2 thread2 =new PrintThread2();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		thread2.interrupt();
		
	}

}
