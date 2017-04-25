package ch11.exam13;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] names = {"È«±æµ¿", "±è¹Î¼ö", "¹Úµ¿¼ö"};
		int[] age ={4,2,3,4,5};

		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(age));
		
		//¿À¸§Â÷¼ø Á¤·Ä
		Arrays.sort(names);
		
		Arrays.sort(age);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(age));
		//³»¸²Â÷¼ø Á¤·Ä 
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names));
		
		Member[] members = {
			new Member("È«±æµ¿", 20),
			new Member("±è¹Î¼ö", 15),
			new Member("¹Úµ¿¼ö", 25)
		};
		
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
		
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));

	}

}
