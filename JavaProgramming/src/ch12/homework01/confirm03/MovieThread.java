package ch12.homework01.confirm03;

public class MovieThread extends Thread{
	@Override
	public void run() {
		while(true){
			System.out.println("�������� ����մϴ�. ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
