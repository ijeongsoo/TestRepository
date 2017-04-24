package ch11.exam13;

import java.util.Arrays;
import java.util.Collections;

public class SortExample {

	public static void main(String[] args) {
		String[] names = {"ȫ�浿", "��μ�", "�ڵ���"};
		int[] age ={4,2,3,4,5};

		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(age));
		
		//�������� ����
		Arrays.sort(names);
		
		Arrays.sort(age);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(age));
		//�������� ���� 
		Arrays.sort(names, Collections.reverseOrder());
		System.out.println(Arrays.toString(names));
		
		Member[] members = {
			new Member("ȫ�浿", 20),
			new Member("��μ�", 15),
			new Member("�ڵ���", 25)
		};
		
		Arrays.sort(members);
		System.out.println(Arrays.toString(members));
		
		Arrays.sort(members, Collections.reverseOrder());
		System.out.println(Arrays.toString(members));

	}

}
