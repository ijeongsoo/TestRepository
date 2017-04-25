package ch15.homework02.confirm03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name=null;
		int maxScore=0;
		int totalScore=0;
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> entry : set){
			totalScore+=entry.getValue();
			if(maxScore<entry.getValue()){
				maxScore=entry.getValue();
				name=entry.getKey();
			}
		}
		
		System.out.println("평균점수:"+(double)totalScore/map.size());
		System.out.println("최고점수:"+maxScore);
		System.out.println("최고점수 받은 ID:"+name);
		
		
	}

}
