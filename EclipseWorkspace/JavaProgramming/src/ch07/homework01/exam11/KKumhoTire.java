package ch07.homework01.exam11;

public class KKumhoTire extends Tire{
	public KKumhoTire(String location, int maxRotation){
		super(location, maxRotation);
	}
	
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if (accumulatedRotation<maxRotation){
			System.out.println(location+"KKumho tire ���� ���� :"+(maxRotation-accumulatedRotation) +"ȸ");
			return true;
		}else{
			System.out.println("*** " +location +"KKumho Tire ��ũ ***");
			return false;
		}
	}
}
