package ch15.homework01.exam06;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		Member obj2 =(Member)obj;
		return (name+age).equals(obj2.name+obj2.age);
	}
}
