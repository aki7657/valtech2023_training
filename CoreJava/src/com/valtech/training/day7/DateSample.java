package com.valtech.training.day7;

import java.time.LocalDate;
import java.util.Date;

public class DateSample {

	public static void main(String[] args) {
//		index of the year starts at 1900
//		index of the month starts from 0
//		index of the day starts from 1

		Date date = new Date(47, 7, 15);
		System.out.println(date);
		LocalDate independanceDay = LocalDate.of(1947, 8, 15);
		System.out.println(independanceDay);

	}

}
