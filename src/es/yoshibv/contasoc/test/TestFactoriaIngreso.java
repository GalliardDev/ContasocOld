package es.yoshibv.contasoc.test;

import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.ingreso.FactoriaIngreso;
import es.yoshibv.contasoc.ingreso.Ingresos;

public class TestFactoriaIngreso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresos ingresos = FactoriaIngreso.leeIngresos(Main.INGRESOS);
		print(ingresos.getIngresos());
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}

}
