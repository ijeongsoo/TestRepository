package ch07.exam09;

public abstract class Tire {
	//F
	int diameter;
	
	//D
	Tire(){
		
		System.out.println("Tire ��ü ����");
	}
	//M
	abstract void roll();

	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	
} 
