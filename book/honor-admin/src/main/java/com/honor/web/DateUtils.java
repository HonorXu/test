package com.honor.web;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DateUtils {

	public static LocalDate parse(String str) {
		String[] s = str.split("\\-|\\/");

			int year = Integer.valueOf(s[0]);
			int month = Integer.valueOf(s[1]);
			int day = s.length > 2 ? Integer.valueOf(s[2]) : 1;
			return LocalDate.of(year, month, day);

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString("2000/9/1".split("\\-|\\/")));
		
		LocalDate of  = LocalDate.parse("2000/9",DateTimeFormatter.ofPattern("yyy/M"));
		System.out.println(of.toString());
	}
}
