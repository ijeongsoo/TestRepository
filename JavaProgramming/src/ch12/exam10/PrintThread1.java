package ch12.exam10;

public class PrintThread1 extends Thread{
	//field
	private boolean stop;
	//constructor
	
	//method
	@Override
	public void run() {
		while(!stop){
			System.out.println("������ ....");
			System.out.println("������ ....");	
		}
		System.out.println("�ڿ� ���� ");
		System.out.println("���� ���� ");
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	
	
}
