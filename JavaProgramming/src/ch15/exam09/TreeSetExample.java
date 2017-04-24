package ch15.exam09;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<>(new CompareByAge());
		set.add(new Person("ȫ�浿", 45));
		set.add(new Person("���ڹ�", 55));
		set.add(new Person("������", 35));
		
		for(Person p : set){
			System.out.println(p.getName()+"("+p.getAge()+")");
		}
		
	}

}
