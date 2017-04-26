package ch12.exam09;

public class DataBox {
	//field
	private String data;
	//constructor

	
	//method

	public synchronized String getData() {
		if(data == null){
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		}
		String returnValue =data;
		System.out.println("���� ������:"+returnValue);
		data=null;
		notify();
		return returnValue;
	}

	public synchronized void setData(String data) {
		if(this.data !=null){
			try{
				wait();
			}catch(InterruptedException e){
				
			}
		}
		this.data = data;
		System.out.println("���� ������:"+this.data);
		notify();
	}
}