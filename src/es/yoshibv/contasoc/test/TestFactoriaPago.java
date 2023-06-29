package es.yoshibv.contasoc.test;

import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.pago.FactoriaPago;
import es.yoshibv.contasoc.pago.Pagos;

public class TestFactoriaPago {
	public static void main(String[] args) {
		Pagos pagos = FactoriaPago.leePagos(Main.PAGOS);
		print(pagos.getPagos());
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
