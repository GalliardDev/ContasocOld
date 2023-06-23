package es.yoshibv.contasoc.test;

import es.yoshibv.contasoc.FactoriaHortelano;
import es.yoshibv.contasoc.Hortelanos;
import es.yoshibv.contasoc.Main;

public class TestFactoriaHortelano {
	public static void main(String[] args) {
		
		Hortelanos hortelanos = FactoriaHortelano.leeHortelano(Main.HORTELANOS);
		print(hortelanos.getHortelanos());
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
