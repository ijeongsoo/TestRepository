package ch08.exam01;

public class Car implements Manual{

	private int speed;

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("�ڵ����� �����մϴ�.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("�ڵ����� ���ϴ�.");
	}

	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		System.out.println("�ӵ���"+speed+"�� �����մϴ�.");
		if(speed<Manual.MIN_SPEED){
			this.speed = speed;
		}else if(speed >Manual.MAX_SPEED){
			this.speed =Manual.MAX_SPEED;
		}else{
			this.speed=speed;
		}
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("�ڵ����� "+speed+"�ӵ��� �޸��ϴ�.");
	}
	

}
