package ch12.homework01.confirm02;

public class MovieThread extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("동영상을 재생합니다. ");
			if(isInterrupted()){
				break;
			}
		}
	}
}
