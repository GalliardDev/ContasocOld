package es.yoshibv.contasoc.test;

import java.time.LocalDate;

import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.ingreso.FactoriaIngreso;
import es.yoshibv.contasoc.ingreso.Ingresos;

public class TestFactoriaIngreso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresos ingresos = FactoriaIngreso.leeIngresos(Main.INGRESOS);
		print(ingresos.getIngresos());
		ingresos.eliminarIngreso(2, LocalDate.of(2023, 6, 23));
		print(ingresos.getIngresos());
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}

}
