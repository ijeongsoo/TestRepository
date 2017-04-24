package ch06.homework02;

import java.util.Scanner;

public class Robot {
	//Field
	Arm[] arm={new Arm("������"), new Arm("����")};
	Head head=new Head();
	Leg[] leg={new Leg("������"), new Leg("����")};
	Power power= new Power();
	
	String maker="Lee Jung Soo";
	String color;
	String name;
	
	//Constructor
	Robot(){
		this("Black","JSBot");
	}
	
	Robot(String name){
		this("Black", name);
	}
	
	Robot(String color, String name){
		this.color=color;
		this.name=name;
		System.out.println(name+"�κ��� �����Ǿ����ϴ�.");
		System.out.println("�̸� :"+name);
		System.out.println("���� :"+color);
		System.out.println("������ :"+maker);
		System.out.println("------------------------------");
		System.out.print("���͸� ������ ������ ���ɴϴ�.>");
	}
	
	//Method
	void powerOn() throws Exception{
		power.start();
	}
	
	void walk(){
		Scanner scanner=new Scanner(System.in);
		head.mouth.ask("�ɾ ���ڱ� ���� �Է��ϼ���:");
		int num=scanner.nextInt();
		for(int i=0; i<num; i++){
			leg[0].move();
			leg[1].move();
		}
		head.mouth.tell("������ ��� ���� ������ϴ�.");
		
		
	}
	
	void powerOff(){
		power.stop();
	}
	
	void seat(){
		leg[0].bend();
		leg[1].bend();
	}
	
	void stand(){
		leg[0].strech();
		leg[1].strech();
	}
	
}
