package ch14.exam07;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

public class CunsumerExample {

	public static void main(String[] args) {
		method1(new Consumer<String>(){
			@Override
			public void accept(String t) {
				for(int i=0; i<5; i++){
					System.out.println(t);
				}
			}
		});
		
		method1((s)->{
			for(int i=0;i<5;i++){
				System.out.println("°ú¸ñ:"+s);
			}
		});
		
		method2((s1,s2)->{
			System.out.println(s1+"-"+s2);
		});
		
		method3((s,i)->{
			for(int k=0; k<i; k++){
				System.out.println(s);
			}
		});
	}

	public static void method1(Consumer<String> arg){
		arg.accept("Java");
	}
	
	public static void method2(BiConsumer<String, String> arg){
		arg.accept("Iot", "JAVA");
	}
	
	
	public static void method3(ObjIntConsumer<String> arg){
		arg.accept("È«±æµ¿", 3);
	}
}
