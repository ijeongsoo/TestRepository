package ch08.homework03.exam08;

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle vehicle=new Bus();
		
		vehicle.run();
		//vehicle.checkFare;
		
		Bus bus =(Bus)vehicle;
		
		bus.run();
		bus.checkFare();
	}

}
