package ch11.exam07;

import java.util.Map;
import java.util.Set;

public class GetEnvExample {

	public static void main(String[] args) {
		String value =System.getenv("USER");
		
		
		Map map= System.getenv();
		Set keys =map.keySet();
		
		
		for(Object objkey : keys){
			String key = (String)objkey;
			String value1 = System.getenv(key);
			System.out.println("["+key+"]"+value1);
		}
	}

}
