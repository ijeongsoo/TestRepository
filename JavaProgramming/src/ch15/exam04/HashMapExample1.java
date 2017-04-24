package ch15.exam04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		map.put("���屺", 80);
		map.put("�ſ��", 85);
		map.put("ȫ�浿", 90);
		map.put("ȫ�浿", 95);
		
		System.out.println("�� Entry�� :"+map.size());
		
		System.out.println("\tȫ�浿 :"+map.get("ȫ�浿"));
		System.out.println();
		
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key=iterator.next();
			Integer value=map.get(key);
			System.out.println("\t"+key+":"+value);
		}
		System.out.println();
		
		map.remove("ȫ�浿");
		System.out.println("�� ��Ʈ�� �� :"+map.size());
		
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
		System.out.println("�� Entry �� :"+map.size());
	}

}
