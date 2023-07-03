package es.yoshibv.contasoc.util;

import java.time.LocalDate;

public class Parsers {
	public static String dateParser(LocalDate date) {
		if(date==null) {
			return null;
		}
		return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
	}
	
	public static String printDateParser(LocalDate date) {
		if(date==null) {
			return "";
		}
		return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
	}
	
	public static String decimalSymbolParser(String cantidad) {
		if(cantidad.contains(",")) {
    		cantidad.replace(",", ".");
    	} else if(cantidad.contains("'")) {
    		cantidad.replace("'", ".");
    	}
		return cantidad;
	}
	
	public static String tipoHortelanoParser(String tipo) {
		if(tipo.equals("LISTA DE ESPERA")) {
			tipo = "LISTA_ESPERA";
		} else if(tipo.equals("HORTELANO+INVERNADERO")) {
			tipo = "HORTELANO_INVERNADERO";
		}
		return tipo;
	}
}
