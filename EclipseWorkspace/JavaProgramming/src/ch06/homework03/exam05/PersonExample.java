package ch06.homework03.exam05;

public class PersonExample {

	public static void main(String[] args) {
		Person p1=new Person("123456-1234567", "���");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		//p1.nation ="usa"; ������ �Ұ���
		//p1.ssn ="654321-7654321"; ������ �Ұ���
		p1.name="��������"; 	//final�� �̳��� ������ ������ �����ϴ�. 
	}

}
