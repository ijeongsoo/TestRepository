package ch12.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {

	public static void main(String[] args) {
		//�Ҹ��� ���� �ڵ� 
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
		//����Ʈ �ϴ� �ڵ� 
		for(int i=0; i<5; i++){
			System.out.println("��");
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				
			}
		}
	}

}
