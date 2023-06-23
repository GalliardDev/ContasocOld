package es.yoshibv.contasoc;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import es.yoshibv.contasoc.common.Cuota;
import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.Tipo;
import es.yoshibv.contasoc.ingreso.Ingreso;
import es.yoshibv.contasoc.util.Fichero;

public class FactoriaHortelano {
	public static Hortelanos leeHortelano(String ruta) {
		List<String> lista = Fichero.leerFichero(ruta);
		SortedMap<Integer,Hortelano> aux = new TreeMap<Integer,Hortelano>();
		for(String s:lista) {
			aux.put(parseaHortelano(s).getSocio(), parseaHortelano(s));
		}
		return new Hortelanos(aux);
	}
	
	public static void escribeHortelano(String hortelano, String ruta) {
		Fichero.escribeFichero(hortelano,ruta);
	}
	
	public static void añadeHortelano(String hortelano, String ruta) {
		Fichero.añadirAlFichero(hortelano, ruta);
	}
	
	public static Hortelano parseaHortelano(String s) {
		String[] t = s.split(";");
		String nombre = t[0];
		String apellidos = t[1];
		String dni = t[2];
		String direccion = t[3];
		String telefono = t[4];
		String correo = t[5];
		Integer socio = Integer.valueOf(t[6].trim());
		Integer huerto = null;
		if(!(t[7].equals(""))) {
			huerto = Integer.valueOf(t[7].trim());
		} else if(t[7].equals("")) {
			huerto = null;
		}
		String[] altaArr = t[8].split("/");
		LocalDate alta = LocalDate.of(Integer.valueOf(altaArr[2]),Integer.valueOf(altaArr[1]),Integer.valueOf(altaArr[0]));
		String[] bajaArr = t[9].split("/");
		LocalDate baja = null;
		if(bajaArr.length == 3) {
			baja = LocalDate.of(Integer.valueOf(bajaArr[2]),Integer.valueOf(bajaArr[1]),Integer.valueOf(bajaArr[0]));
		} else {
			baja = null;
		}
		Estado estado = Estado.valueOf(t[10]);
		Tipo tipo = Tipo.valueOf(t[11]);
		List<Ingreso> ingresos = null;
		if(t[12].equals("[]")) {
			ingresos = new ArrayList<Ingreso>();
		} else {
			ingresos = new ArrayList<Ingreso>();
			String[] ingArr = t[12].replace("[", "").replace("]", "").split(",");
			for(String ingStr:ingArr) {
				String[] aux = ingStr.split("-");
				String[] fechaArr = aux[0].split("/");
				LocalDate fecha = LocalDate.of(Integer.valueOf(fechaArr[2]),Integer.valueOf(fechaArr[1]),Integer.valueOf(fechaArr[0]));
				String concepto = aux[1];
				Double cantidad = Double.valueOf(aux[2].trim());
				Cuota cuota = Cuota.valueOf(aux[3]);
				ingresos.add(new Ingreso(fecha,concepto,cantidad,cuota));
			}
		}
		
		Hortelano h = new Hortelano(new Persona(nombre,apellidos,dni,direccion,telefono,correo),
				socio,huerto,alta,baja,estado,tipo);
		ingresos.stream().forEach(x->h.añadirIngreso(x));
		return h;
	}
}
