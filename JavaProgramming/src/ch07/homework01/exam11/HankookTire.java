package ch07.homework01.exam11;

public class HankookTire extends Tire {
	public HankookTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation<maxRotation){
			System.out.println(location+"Hankook tire ���� ���� :"+(maxRotation-accumulatedRotation) +"ȸ");
			return true;
		}else{
			System.out.println("*** " +location +"Hankook Tire ��ũ ***");
			return false;
		}
	}
}
