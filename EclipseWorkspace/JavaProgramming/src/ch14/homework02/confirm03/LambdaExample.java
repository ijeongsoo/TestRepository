package ch14.homework02.confirm03;

import java.util.function.ToDoubleFunction;

public class LambdaExample {

	private static Student[] students ={
			new Student("홍길동",90,96),
			new Student("신용권",95,93)
	};
	
	
	public static double avg(ToDoubleFunction<Student> s){
		double sum=0;
		for(int i=0; i<students.length;i++){
			sum+=s.applyAsDouble(students[i]);
		}
		
		return sum/students.length;
		
	}
	
	
	public static void main(String[] args) {
		//double englishAvg = avg(s->s.getEnglishScore());
		double englishAvg = avg(Student::getEnglishScore);
		System.out.println("영어 평균 점수:"+englishAvg);
		//double mathAvg = avg(s->s.getMathScore());
		double mathAvg=avg(Student::getMathScore);
		System.out.println("수 평균 점수:"+mathAvg);

	}
	
	public static class Student{
		private String name;
		private int englishScore;
		private int mathScore;
		
		public Student(String name, int englishScore, int mathScore){
			this.name=name;
			this.englishScore=englishScore;
			this.mathScore=mathScore;
		}
		
		public String getName(){return name;}
		public int getEnglishScore(){return englishScore;}
		public int getMathScore(){return mathScore;}
	}

}
