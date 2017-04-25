package ch15.exam04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("µ¿Àå±º", 80);
		map.put("½Å¿ë±Ç", 85);
		map.put("È«±æµ¿", 90);
		map.put("È«±æµ¿", 95);
		
		System.out.println("ÃÑ Entry¼ö :"+map.size());
		
		System.out.println("\tÈ«±æµ¿ :"+map.get("È«±æµ¿"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key=iterator.next();
			Integer value=map.get(key);
			System.out.println("\t"+key+":"+value);
		}
		System.out.println();
		
		map.remove("È«±æµ¿");
		System.out.println("ÃÑ ¿£Æ®¸® ¼ö :"+map.size());
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator1= entrySet.iterator();
		
		while(iterator1.hasNext()){
			Map.Entry<String, Integer> entry =iterator1.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t"+key+":"+value);
		}
		System.out.println();
		
		map.clear();
		System.out.println("ÃÑ Entry ¼ö :"+map.size());
	}

}
