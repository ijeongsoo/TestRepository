package ch11.homework03.confirm10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataPrintExample {

	public static void main(String[] args) {
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy�� MM�� dd�� E���� hh�� mm�� ");
		String str = sdf.format(now);
		System.out.println(str);
	}

}
