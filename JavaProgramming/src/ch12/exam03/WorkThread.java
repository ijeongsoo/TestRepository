package ch12.exam03;

public class WorkThread extends Thread{
	//Filed
	
	//Constructor
	WorkThread(String threadName){
		super(threadName);
	}
	//Method
	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		for(int i=0; i<2; i++){
			System.out.println(threadName + "가 출력한 내용 ");
		}
	}
}
