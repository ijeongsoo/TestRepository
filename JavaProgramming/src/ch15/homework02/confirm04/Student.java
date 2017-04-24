package ch15.homework02.confirm04;

public class Student implements Comparable<Student>{
	public String id;
	public int score;
	public Student(String id, int score) {
		this.id = id;
		this.score = score;
	}
	@Override
	public int compareTo(Student o) {
		if(this.score>o.score) return 1;
		else if(this.score==o.score) return 0;
		else return -1;
	}
	
}
