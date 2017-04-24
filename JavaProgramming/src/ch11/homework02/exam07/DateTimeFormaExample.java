package ch11.homework02.exam07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormaExample {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormater = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
		String nowString = now.format(dateTimeFormater);
		System.out.println(nowString);
	}

}
