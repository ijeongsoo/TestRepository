package ch12.exam04;

public class PriorityExample {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++){
			Thread thread = new CalcThread("thread"+i);
			if(i!=10){
				thread.setPriority(1);
			}else{
				thread.setPriority(10);
			}
			thread.start();
		}
	}

}
