package ch15.homework01.exam17;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparableExample {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("ȫ�浿", 45));
		set.add(new Person("���ڹ�", 25));
		set.add(new Person("������", 35));
		
		Iterator<Person> iterator =  set.iterator();
		while(iterator.hasNext()){
			Person person = iterator.next();
			System.out.println(person.name+":"+person.age);
		}
		
	}

}
