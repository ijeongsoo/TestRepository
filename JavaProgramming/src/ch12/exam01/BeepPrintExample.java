package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		//소리를 내는 코드 
		/*Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0; i<5; i++){
			toolkit.beep();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				
			}
		}*/
		
		/*
		BeepTest beepTask  = new BeepTest();
		Thread thread = new Thread(beepTask);
		thread.start();
		*/
		
		Thread thread = new Thread(new Runnable(){

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
			
		});
		
		System.out.println(thread.getName());
		
		thread.start();
		//프린트 하는 코드 
		for(int i=0; i<5; i++){
			System.out.println("띵");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				
			}
		}
	}

}
