package ch06.homework03.exam05;

public class Person {
	//nation final ���� �� �ʱ�ȭ, �ٲܼ� ���� 
	final String nation ="Korea";
	
	//ssn final ���� , �ʱ�ȭ�� ������ 
	final String ssn;
	String name;
	//������ ȣ��� ssn�ʱ�ȭ 
	public Person(String ssn, String name){
		this.ssn=ssn;
		this.name=name;
	}
}
