package ch11.exam13;

import java.util.Arrays;

public class Member implements Comparable<Member>{
	private String name;
	private int age;
	public Member(String name, int age){
		this.name=name;
		this.age=age;
	}
	
	@Override
	public String toString() {
		return name+"("+age+")";
	}

	@Override
	public int compareTo(Member o) {
		String str = String.valueOf(age);
		String str1= String.valueOf(o.age);
		return str.compareTo(str1);
		
		//return Integer.compare(age, o.age);
	}
}
