package ch06.homework02;

public class Leg {
	//Field
	String location;
	boolean bendState=false;
	//Construct
	Leg(String location){
		this.location=location;
	}
	
	//Method
	void move(){
		System.out.println(location+"�ٸ��� ������ �Ű���ϴ�.");
	}
	
	void bend(){
		if(bendState==true){
			System.out.println(location+"�ٸ��� �̹� ���ηȽ��ϴ�.");
		}else{
			System.out.println(location+"�ٸ��� ���ηȽ��ϴ�.");
			bendState= true;	
		}
		
	}
	
	void strech(){
		if(bendState==false){
			System.out.println(location+"�ٸ��� �̹� �����ֽ��ϴ�.");
		}else{
			System.out.println(location+"�ٸ��� ����ϴ�.");
			bendState= false;
		}
		
	}
}
