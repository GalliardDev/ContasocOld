package es.yoshibv.contasoc.test;

import java.util.stream.Collectors;

import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.ingreso.FactoriaIngreso;
import es.yoshibv.contasoc.ingreso.Ingresos;

public class TestFactoriaIngreso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingresos ingresos = FactoriaIngreso.leeIngresos(Main.INGRESOS);
		print(ingresos.getIngresos());
		print(ingresos.getIngresos().entrySet().stream()
    			.map(e->e.getValue()).toList().stream()
    			.flatMap(x->x.stream())
    			.collect(Collectors.summingDouble(x->x.getCantidad())));
		print(ingresos.getIngresosPorNumero(147));
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}

}
