package ch12.exam01;

import java.awt.Toolkit;

public class BeepTest implements Runnable{
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++){
			toolkit.beep();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				
			}
		}
	}
}
