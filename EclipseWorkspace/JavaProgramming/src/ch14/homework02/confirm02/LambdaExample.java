package ch14.homework02.confirm02;

import java.util.function.IntBinaryOperator;

public class LambdaExample {

	private static int[] scores={10,50,3};
	
	public static int maxOrMin(IntBinaryOperator operator){
		int result = scores[0];
		for(int sore :scores){
			result = operator.applyAsInt(result, sore);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int max = maxOrMin((result, score)->{
			if(score>result){
				result=score;
			}
			return result;
		});
				
		System.out.println("최대값:"+max);
		
		int min = maxOrMin((result, score)->{
			if(score<result){
				result=score;
			}
			return result;
		});
		
		System.out.println("최소값:"+min);
	}

}
