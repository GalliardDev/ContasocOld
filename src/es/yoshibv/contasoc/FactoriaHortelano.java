package es.yoshibv.contasoc;

import java.time.LocalDate;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.TipoHortelano;
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
	
	public static Hortelanos leeHortelano2(String ruta) {
		List<String> lista = Fichero.leerFichero(ruta);
		SortedMap<Integer,Hortelano> aux = new TreeMap<Integer,Hortelano>();
		for(String s:lista) {
			aux.put(parseaHortelanoCsv(s).getSocio(), parseaHortelanoCsv(s));
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
		String huerto = t[7];
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
		TipoHortelano tipo = TipoHortelano.valueOf(t[11]);
	
		Hortelano h = new Hortelano(new Persona(nombre,apellidos,dni,direccion,telefono,correo),
				socio,huerto,alta,baja,estado,tipo);
		
		return h;
	}
	
	public static Hortelano parseaHortelanoCsv(String s) {
		String[] t = s.split(";");
		Integer numSocio = Integer.valueOf(t[0].trim());
		String nombre = t[1];
		String apellidos = t[2];
		String dni = t[3];
		String direccion = t[4];
		String telefono = t[5];
		String correo = t[6];
		String numHuerto = t[7];
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
		TipoHortelano tipo = TipoHortelano.valueOf(t[11]);
		
		Hortelano h = new Hortelano(new Persona(nombre,apellidos,dni,direccion,telefono,correo),
				numSocio,numHuerto,alta,baja,estado,tipo);
		
		return h;
	}
}
