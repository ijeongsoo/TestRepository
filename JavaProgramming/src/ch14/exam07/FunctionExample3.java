package ch14.exam07;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public class FunctionExample3 {

	public static void main(String[] args) {
		
		method1((d)->{
			return (int)d;
		});
		
		method1((d)->{
			return (int)Math.round(d);
		});
		
		method2((m)->{
			return m.getMid();
		});
		
	}
	
	public static void method1(DoubleToIntFunction arg){
		int result = arg.applyAsInt(3.54);
		System.out.println(result);
	}
	
	public static void method2(Function<Member, String> arg){
		Member t =new Member("white", "ȫ�浿");
		String result=arg.apply(t);
	}

	
	
}
