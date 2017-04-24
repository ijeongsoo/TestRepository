package ch12.exam11;

public class AutoSaveThread extends Thread{
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				save();
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	
	
	public void save(){
		System.out.println("작업내용을 저장함");
	}
}
