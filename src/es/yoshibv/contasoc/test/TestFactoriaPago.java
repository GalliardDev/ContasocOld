package es.yoshibv.contasoc.test;

import java.time.LocalDate;

import es.yoshibv.contasoc.pago.FactoriaPago;
import es.yoshibv.contasoc.pago.Pago;
import es.yoshibv.contasoc.pago.Pagos;

public class TestFactoriaPago {
	public static void main(String[] args) {
		Pagos pagos = FactoriaPago.leePagos("./data/pagos.csv");
		for(Pago p:pagos.getPagosPorFecha(LocalDate.of(2023, 4, 4))) {
			print(p);
		}
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
