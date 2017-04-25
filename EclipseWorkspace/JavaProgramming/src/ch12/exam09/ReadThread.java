package ch12.exam09;

public class ReadThread extends Thread{
	//field
	private DataBox dataBox;
	//construct
	public ReadThread(DataBox dataBox){
		this.dataBox=dataBox;
	}
	//method
	
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			String data=dataBox.getData();
		}
	}
}
