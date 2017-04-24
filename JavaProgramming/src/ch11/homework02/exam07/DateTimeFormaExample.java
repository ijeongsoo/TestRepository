package ch11.homework02.exam07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormaExample {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormater = DateTimeFormatter.ofPattern("yyyy�� M�� d�� a h�� m��");
		String nowString = now.format(dateTimeFormater);
		System.out.println(nowString);
	}

}
