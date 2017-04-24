package ch14.exam09;


import java.util.function.IntBinaryOperator;

public class LambdaExpressionExample {
	
	
	private static int[] scores={92,95,87};
	
	public static void main(String[] args) {
		int max=maxOrMin((r,s)->{
			if(r<s){
				return s;
			}
			return r;
		});
		System.out.println(max);
		
		int min=maxOrMin((r,s)->{
			if(r>s){
				return s;
			}
			return r;
		});
		System.out.println(min);
	}
	
	
	public static int maxOrMin(IntBinaryOperator operator){
		int result=scores[0];
		for(int score : scores){
			result=operator.applyAsInt(result, score);
		}
		
		return result;
	}
	

}
