package es.yoshibv.contasoc.pago;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import es.yoshibv.contasoc.Main;

public class FactoriaPago {
	public static Pagos leePagos(String ruta) {
		List<Pago> res = null;
		try {
			res = Files.readAllLines(Path.of(Main.PAGOS)).stream()
					.map(x->parseaPago(x)).toList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Pagos(res);
	}
	
	public static Pago parseaPago(String s) {
		String[] t = s.split(";");
		LocalDate fecha = LocalDate.parse(t[0],DateTimeFormatter.ofPattern("d/M/yyyy"));
		String proveedor = t[1];
		String concepto = t[2];
		Double cantidad = Double.parseDouble(t[3].trim());
		String factura = t[4];
		return new Pago(fecha,proveedor,concepto,cantidad,factura);
	}
}
