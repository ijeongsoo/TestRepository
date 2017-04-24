package ch11.homework03.confirm08;

public class IntegerCompareExample {

	public static void main(String[] args) {
		Integer obj1=100;
		Integer obj2=100;
		Integer obj3=300;
		Integer obj4=300;
		
		System.out.println(obj1==obj2);
		System.out.println(obj3==obj4);
		
		//-128~127까지의 정수는 == 비교할시 값을 비교 하지만 이범위가 아니면 값이 아닌 객체를 비교함  
	}

}
