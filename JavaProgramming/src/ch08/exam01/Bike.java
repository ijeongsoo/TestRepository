package ch08.exam01;

public class Bike implements Manual{
	private int speed;
	
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("���������Ÿ� �����մϴ�.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("���������Ÿ� ���ϴ�.");
	}

	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		System.out.println("�ӵ���"+speed+"�� �����մϴ�.");
		this.speed = speed;
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("���� �����Ű� "+speed+"�ӵ��� �޸��ϴ�.");
	}
	
	
}
