package ch06.exam06;

public class Calculator {
	//Field
	String field1 ="value1";
	static String field2="value2";
	
	//Method
	void method1(){
		System.out.println(field1);
	}
	
	static void method2(){
		//System.out.println(field1); 이경우 에러남
	}
}
