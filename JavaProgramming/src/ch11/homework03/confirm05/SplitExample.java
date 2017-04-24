package ch11.homework03.confirm05;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		String [] str1=str.split(",");
		for(String temp : str1){
			System.out.println(temp);
		}
		
		System.out.println();
		
		StringTokenizer stn= new StringTokenizer(str, ",");
		while(stn.hasMoreTokens()){
			String temp=stn.nextToken();
			System.out.println(temp);
		}
	}

}
