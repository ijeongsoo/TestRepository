package ch12.exam10;

public class PrintThread2 extends Thread{
	//field
	private boolean stop;
	//constructor
	
	//method
	@Override
	public void run() {
		try{
			while(true){
				System.out.println("������ ....");
				System.out.println("������ ....");	
			
				if(isInterrupted()){
					break;
				}
			}
		}catch(Exception e){
			
		}
		System.out.println("�ڿ� ���� ");
		System.out.println("���� ���� ");
	}

	
	
	
	
}
