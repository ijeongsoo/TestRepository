package ch11.homework03.confirm01;

import java.util.HashMap;

public class StudentExample {

	public static void main(String[] args) {
		HashMap<Student, String> hashMap = new HashMap<Student, String>();
		
		hashMap.put(new Student("1"), "95");
		hashMap.put(new Student("1"), "100");
		int num = hashMap.size();
		String score =hashMap.get(new Student("1"));
		System.out.println("1번학생의 총점:"+score);
		System.out.println(num);
	}

}
