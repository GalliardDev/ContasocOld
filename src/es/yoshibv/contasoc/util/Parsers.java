package es.yoshibv.contasoc.util;

import java.time.LocalDate;

public class Parsers {
	public static String dateParser(LocalDate date) {
		if(date==null) {
			return null;
		}
		return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
	}
}
