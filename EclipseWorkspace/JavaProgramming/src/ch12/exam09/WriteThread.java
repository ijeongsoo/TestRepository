package ch12.exam09;

public class WriteThread extends Thread{
	//field
	private DataBox dataBox;
	//construct
	public WriteThread(DataBox dataBox){
		this.dataBox=dataBox;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++){
			dataBox.setData(String.valueOf(i));
		}
	}
}
