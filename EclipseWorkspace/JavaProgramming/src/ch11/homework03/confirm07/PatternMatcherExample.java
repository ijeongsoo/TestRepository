package ch11.homework03.confirm07;

import java.util.regex.Pattern;

public class PatternMatcherExample {

	public static void main(String[] args) {
		String id = "5Angel1004";
		String regExp = "[a-z,A-Z]\\w{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		if(isMatch){
			System.out.println("���̵�� ��밡��");
		}else{
			System.out.println("���̵�� ��� �Ұ���");
		}
	}

}