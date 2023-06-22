package es.yoshibv.contasoc.pago;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import es.yoshibv.contasoc.util.Fichero;

public class FactoriaPago {
	public static Pagos leePagos(String ruta) {
		List<String> lista = Fichero.leerFichero(ruta);
		SortedSet<Pago> aux = lista.stream()
				.map(x->parseaPago(x))
				.sorted(Comparator.comparing(Pago::getFecha))
				.collect(Collectors.toCollection(TreeSet::new));
		return new Pagos(aux);
		
	}
	
	public static Pago parseaPago(String s) {
		String[] t = s.split(";");
		String[] fechaArr = t[0].split("/");
		LocalDate fecha = LocalDate.of(Integer.valueOf(fechaArr[2]),Integer.valueOf(fechaArr[1]),Integer.valueOf(fechaArr[0]));
		String proveedor = t[1];
		String concepto = t[2];
		Double cantidad = Double.parseDouble(t[3].trim());
		String factura = t[4];
		return new Pago(fecha,proveedor,concepto,cantidad,factura);
	}
}
