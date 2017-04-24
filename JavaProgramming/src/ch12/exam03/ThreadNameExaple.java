package ch12.exam03;

public class ThreadNameExaple {

	public static void main(String[] args) {
		//String threadName=Thread.currentThread().getName();
		Thread mainThread = Thread.currentThread();
		String threadName = mainThread.getName();
		System.out.println(threadName);
		
		
		WorkThread wt1 = new WorkThread("wt1");
		wt1.start();
		
		
		WorkThread wt2 = new WorkThread("wt2");
		wt2.start();
	}

}
