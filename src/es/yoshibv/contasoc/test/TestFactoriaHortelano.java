package es.yoshibv.contasoc.test;

import java.util.Map.Entry;

import es.yoshibv.contasoc.FactoriaHortelano;
import es.yoshibv.contasoc.Hortelano;
import es.yoshibv.contasoc.Hortelanos;

public class TestFactoriaHortelano {
	public static void main(String[] args) {
		/*Hortelanos hortelanos = FactoriaHortelano.leeHortelano("./data/test.csv");
		for(Entry<Integer,Hortelano> e:hortelanos.getHortelanos().entrySet()) {
			FactoriaHortelano.añadeHortelano(e.getValue().toString(), "./data/data.csv");
		}*/
		Hortelanos hortelanos2 = FactoriaHortelano.leeHortelano("./data/hortelanos.csv");
		print(hortelanos2.getHortelanoPorNumero(143));
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
