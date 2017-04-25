package ch08.homework02.confirm03;

public class SnowTireExample {
	public static void main(String[] args){
		SnowTire snowTire = new SnowTire();
		Tire tire= snowTire;
		
		snowTire.run();
		tire.run();
	}
}
