package es.yoshibv.contasoc.test;

import es.yoshibv.contasoc.FactoriaHortelano;
import es.yoshibv.contasoc.Hortelanos;

public class TestFactoriaHortelano {
	public static void main(String[] args) {
		
		Hortelanos hortelanos = FactoriaHortelano.leeHortelano("./data/hortelanos.csv");
		print(hortelanos.getHortelanos().lastKey());
		print(hortelanos.getHortelanoPorNumero(3));
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
