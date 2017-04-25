package ch15.exam01;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

	public static void main(String[] args) {
		Student [] studentArr = new Student[3];
		studentArr[0]=new Student("s1");
		studentArr[1]=new Student("s2");
		studentArr[2]=new Student("s3");
		//studentArr[3]=new Student("s4");
		studentArr[2]=null;
		
		List<Student> list = new ArrayList<>();
		for(int i=0; i<100; i++){
			list.add(new Student("s"+i));
		}
		list.remove(1);
	}

}
