package ch14.exam07;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public class SupplierExample2 {

	public static void main(String[] args) {
		
		method1(()->{
			return "aaa";
		});
		
		method2(()->{
			return 5;
		});
		
	}
	
	public static void method1(Supplier<String> arg){
		String result = arg.get();
		System.out.println(result);
	}

	public static void method2(IntSupplier arg){
		int result = arg.getAsInt();
		System.out.println(result);
	}
	
}
