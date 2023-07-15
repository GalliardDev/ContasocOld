package es.yoshibv.contasoc.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.TipoHortelano;
import es.yoshibv.contasoc.common.TipoRetribucion;
import es.yoshibv.contasoc.ingreso.Ingreso;
import es.yoshibv.contasoc.pago.Pago;
import es.yoshibv.contasoc.persona.Persona;
import es.yoshibv.contasoc.persona.hortelano.Hortelano;

public class Parsers {
	public static String dateParser(LocalDate date) {
		if(date==null) {
			return null;
		}
		return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
	}
	
	public static String printDateParser(LocalDate date) {
		if(date==null) {
			return "";
		}
		return date.getDayOfMonth()+"/"+date.getMonthValue()+"/"+date.getYear();
	}
	
	public static String decimalSymbolParser(String cantidad) {
		if(cantidad.contains(",")) {
    		cantidad.replace(",", ".");
    	} else if(cantidad.contains("'")) {
    		cantidad.replace("'", ".");
    	}
		return cantidad;
	}
	
	public static String tipoHortelanoParser(String tipo) {
		if(tipo.equals("LISTA DE ESPERA")) {
			tipo = "LISTA_ESPERA";
		} else if(tipo.equals("HORTELANO + INV")) {
			tipo = "HORTELANO_INVERNADERO";
		}
		return tipo;
	}
	
	public static Ingreso ingresoParser(String s) {
		String[] t = s.split(";");
		Integer socio = Integer.valueOf(t[0].trim());
		String[] fechaArr = t[1].split("/");
		LocalDate fecha = LocalDate.of(Integer.valueOf(fechaArr[2]),Integer.valueOf(fechaArr[1]),Integer.valueOf(fechaArr[0]));
		String concepto = t[2];
		Double cantidad = Double.valueOf(t[3].trim());
		TipoRetribucion tipo = TipoRetribucion.valueOf(t[4]);
		return new Ingreso(socio,fecha,concepto,cantidad,tipo);
	}
	
	public static Hortelano hortelanoParser(String s) {
		String[] t = s.split(";");
		String huerto = t[0];
		Integer socio = Integer.valueOf(t[1].trim());
		String nombre = t[2];
		String dni = t[3];
		String telefono = t[4];
		String correo = t[5];
		String[] altaArr = t[6].split("/");
		LocalDate alta = LocalDate.of(Integer.valueOf(altaArr[2]),Integer.valueOf(altaArr[1]),Integer.valueOf(altaArr[0]));
		String[] entregaArr = t[7].split("/");
		LocalDate entrega = null;
		String[] bajaArr = t[8].split("/");
		LocalDate baja = null;
		if(entregaArr.length == 3) {
			entrega = LocalDate.of(Integer.valueOf(entregaArr[2]),Integer.valueOf(entregaArr[1]),Integer.valueOf(entregaArr[0]));
		} else {
			entrega = null;
		}
		if(bajaArr.length == 3) {
			baja = LocalDate.of(Integer.valueOf(bajaArr[2]),Integer.valueOf(bajaArr[1]),Integer.valueOf(bajaArr[0]));
		} else {
			baja = null;
		}
		String notas = t[9];
		TipoHortelano tipo = TipoHortelano.valueOf(t[10]);
		Estado estado = Estado.valueOf(t[11]);
	
		Hortelano h = new Hortelano(huerto, socio, new Persona(nombre,dni,telefono,correo),
				alta,entrega,baja,notas,tipo,estado);
		
		return h;
	}
	
	public static Pago pagoParser(String s) {
		String[] t = s.split(";");
		LocalDate fecha = LocalDate.parse(t[0],DateTimeFormatter.ofPattern("d/M/yyyy"));
		String proveedor = t[1];
		String concepto = t[2];
		Double cantidad = Double.parseDouble(t[3].trim());
		String factura = t[4];
		TipoRetribucion tipo = TipoRetribucion.valueOf(t[5]);
		return new Pago(fecha,proveedor,concepto,cantidad,factura,tipo);
	}
}
