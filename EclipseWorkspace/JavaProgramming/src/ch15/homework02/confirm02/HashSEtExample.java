package ch15.homework02.confirm02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSEtExample {

	public static void main(String[] args) {
		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1,"ȫ�浿"));
		set.add(new Student(2,"�ſ��"));
		set.add(new Student(1,"���ο�"));
		
		Iterator<Student> iterator = set.iterator();
		while(iterator.hasNext()){
			Student student=iterator.next();
			System.out.println(student.studentNum+":"+student.name);
		}
	}

}
