package ch12.exam05;

public class User1 extends Thread{
	private Calculator calculator;
	
	public User1(String name){
		super(name);
	}
	@Override
	public void run() {
		calculator.setMemory(100);
	}
	public void setCaculator(Calculator caculator) {
		this.calculator = caculator;
	}
}
