package ch08.homework03.exam09;

public class Bus implements Vehicle{

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	
	public void checkFare(){
		System.out.println("버스 요금을 체크합니다.");
	}

}
