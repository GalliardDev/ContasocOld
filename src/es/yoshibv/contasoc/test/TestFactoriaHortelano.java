package es.yoshibv.contasoc.test;

import es.yoshibv.contasoc.FactoriaHortelano;
import es.yoshibv.contasoc.Hortelanos;
import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.ingreso.FactoriaIngreso;
import es.yoshibv.contasoc.ingreso.Ingresos;

public class TestFactoriaHortelano {
	public static void main(String[] args) {
		
		Hortelanos hortelanos = FactoriaHortelano.leeHortelano(Main.HORTELANOS);
		Ingresos ingresos = FactoriaIngreso.leeIngresos(Main.INGRESOS);
		print(hortelanos.getNombreHortelanoPorNumeroDeSocio(147));
		print(ingresos.getIngresosPorNumero(147));
		print(hortelanos.getNombreHortelanoPorNumeroDeSocio(5));
		print(ingresos.getIngresosPorNumero(5));
		print(hortelanos.getNombreHortelanoPorNumeroDeSocio(320));
		print(ingresos.getIngresosPorNumero(320));
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
