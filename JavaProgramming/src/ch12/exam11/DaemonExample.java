package ch12.exam11;

public class DaemonExample {

	public static void main(String[] args) {
		System.out.println("워드 프로세스를 시작함 ");
		
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		
		try{Thread.sleep(5000);}catch(Exception e){}
		System.out.println("워드 프로세스를 종료함 ");
	}
	

}
