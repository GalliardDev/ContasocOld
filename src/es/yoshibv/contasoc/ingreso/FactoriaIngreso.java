package es.yoshibv.contasoc.ingreso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import es.yoshibv.contasoc.common.Cuota;
import es.yoshibv.contasoc.util.Fichero;

public class FactoriaIngreso {
	private static Integer socio = null;
	
	public static Integer getSocio() {
		return socio;
	}
	
	public static Ingresos leeIngresos(String ruta) {
		List<String> lista = Fichero.leerFichero(ruta);
		SortedMap<Integer,List<Ingreso>> res = new TreeMap<Integer,List<Ingreso>>();
		for(String s:lista) {
			List<Ingreso> aux = parseaIngresos(s);
			res.put(socio, aux);
		}
		return new Ingresos(res);
	}
	
	public static void escribeIngresos(String ingreso, String ruta) {
		Fichero.escribeFichero(ingreso,ruta);
	}
	
	public static void añadeIngresos(String ingreso, String ruta) {
		Fichero.añadirAlFichero(ingreso, ruta);
	}
	
	public static List<Ingreso> parseaIngresos(String s) {
		String[] t = s.split(";");
		List<Ingreso> ingresos = null;
		if(t[1].equals("[]")) {
			socio = Integer.valueOf(t[0].trim());
			ingresos = new ArrayList<Ingreso>();
		} else {
			ingresos = new ArrayList<Ingreso>();
			String[] ingArr = t[1].replace("[", "").replace("]", "").split(",");
			for(String ingStr:ingArr) {
				socio = Integer.valueOf(t[0].trim());
				String[] aux = ingStr.split("-");
				String[] fechaArr = aux[0].split("/");
				LocalDate fecha = LocalDate.of(Integer.valueOf(fechaArr[2]),Integer.valueOf(fechaArr[1]),Integer.valueOf(fechaArr[0]));
				String concepto = aux[1];
				Double cantidad = Double.valueOf(aux[2].trim());
				Cuota cuota = Cuota.valueOf(aux[3]);
				ingresos.add(new Ingreso(fecha,concepto,cantidad,cuota));
			}
		}
		return ingresos;
	}
}
