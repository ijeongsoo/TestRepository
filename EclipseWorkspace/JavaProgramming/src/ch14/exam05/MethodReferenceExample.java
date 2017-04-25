package ch14.exam05;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		method(new FunctionalInterface1() {
			
			@Override
			public boolean method(String a, String b) {
				return a.equals(b);
			}
		});
		
		
		method((a,b)->{return a.equals(b);});
		method((a,b)->a.equals(b));
		method(String::equals);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	public static void method(FunctionalInterface1 i){
		boolean result = i.method("java", "java");
		System.out.println(result);
	}
}
