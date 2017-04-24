package ch14.exam08;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class LambdaExpressionExample {
	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 90,96),
			new Student("감자바", 95, 93)
	);
	public static void main(String[] args) {
		printString((s)->s.getName());
		printInt(s->s.getEngScore());
		printInt(s->s.getMathScore());
		
		System.out.println("영어평균점수:"+avg(s->s.getEngScore()));
		System.out.println("수학평균점수:"+avg(s->s.getMathScore()));
	}
	
	public static void printString (Function<Student, String> function){
		for(Student student : list){
			System.out.println(function.apply(student)+"");
		}
		System.out.println();
	}
	
	public static void printInt (ToIntFunction<Student> f){
		for(Student student : list){
			System.out.println(f.applyAsInt(student));
		}
		System.out.println();
	}
	
	public static double avg(ToDoubleFunction<Student> f){
		double sum = 0;
		for(Student student : list){
			sum+=f.applyAsDouble(student);
		}
		return sum/list.size();
	}

}
