package ch06.homework01;

public class Car5Example {

	public static void main(String[] args) {
		Car5 myCar = new Car5();
		
		myCar.setGas(5);	//setGas()�޼ҵ� ȣ��
		
		boolean gasState=myCar.isLeftGas();
		if(gasState){
			System.out.println("����մϴ�:");
			myCar.run();
		}
		
		if(myCar.isLeftGas()){
			System.out.println("gas�� ������ �ʿ䰡 �����ϴ�.");
		}else{
			System.out.println("gas�� �����ϼ���.");
		}
	}
	

}
