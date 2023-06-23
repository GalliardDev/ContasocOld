package es.yoshibv.contasoc.pago;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import es.yoshibv.contasoc.util.Fichero;

public class FactoriaPago {
	private static String proveedorKey = null;
	
	public static Pagos leePagos(String ruta) {
		List<String> lista = Fichero.leerFichero(ruta);
		SortedMap<String,List<Pago>> res = new TreeMap<String,List<Pago>>();
		List<Pago> aux = lista.stream().map(x->parseaPago(x)).filter(x->x.getProveedor().equals(proveedorKey)).toList();
		res.put(proveedorKey, aux);
		return new Pagos(res);
		
	}
	
	public static Pago parseaPago(String s) {
		String[] t = s.split(";");
		String[] fechaArr = t[0].split("/");
		LocalDate fecha = LocalDate.of(Integer.valueOf(fechaArr[2]),Integer.valueOf(fechaArr[1]),Integer.valueOf(fechaArr[0]));
		String proveedor = t[1];
		proveedorKey = proveedor;
		String concepto = t[2];
		Double cantidad = Double.parseDouble(t[3].trim());
		String factura = t[4];
		return new Pago(fecha,proveedor,concepto,cantidad,factura);
	}
}
