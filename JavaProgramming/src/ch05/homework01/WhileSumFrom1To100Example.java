package ch05.homework01;

public class WhileSumFrom1To100Example {

	public static void main(String[] args) {
		int sum=0;	//합계저장 변수
		
		int i=1;	//카운터 변수
		
		//1부터 100까지 합
		while(i<=100){
			sum+=i;
			i++;
		}
		
		System.out.println("1~"+(i-1)+" 합:"+sum);
	}

}
