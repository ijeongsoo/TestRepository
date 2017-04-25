package ch11.homework02.exam04;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateTimeChangeExample {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재 :"+now);
		
		LocalDateTime targetDateTime =null;
		
		targetDateTime =now.withYear(2024).withMonth(10).withDayOfMonth(5).withHour(13).withMinute(30).withSecond(20);
		System.out.println("직접 변경 : "+targetDateTime);
		
		targetDateTime = now.with(TemporalAdjusters.firstDayOfYear());
		System.out.println("이번해의 첫일 :"+targetDateTime);
		targetDateTime = now.with(TemporalAdjusters.lastDayOfYear());
		System.out.println("이번해의 마지막일 :"+targetDateTime);
		targetDateTime = now.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println("다음해의 첫일 :"+targetDateTime);
		
		targetDateTime = now.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("이번달의 첫일 :"+targetDateTime);
		targetDateTime = now.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("이번달의 마지막일 :"+targetDateTime);
		targetDateTime = now.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.println("다음달의 첫일 :"+targetDateTime);
		
		targetDateTime = now.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		System.out.println("이번달의 첫요일 :"+targetDateTime);
		targetDateTime = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("돌아오는 월요일 :"+targetDateTime);
		targetDateTime = now.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
		System.out.println("지난 월요일 :"+targetDateTime);
	}

}
