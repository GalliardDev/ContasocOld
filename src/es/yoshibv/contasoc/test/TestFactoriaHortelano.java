package es.yoshibv.contasoc.test;

import java.util.Map.Entry;

import es.yoshibv.contasoc.FactoriaHortelano;
import es.yoshibv.contasoc.Hortelano;
import es.yoshibv.contasoc.Hortelanos;

public class TestFactoriaHortelano {
	public static void main(String[] args) {
		
		//Hortelanos hortelanos = FactoriaHortelano.leeHortelano(Main.HORTELANOS);
		//print(hortelanos.getHortelanos());
		
		//List<String> aux = new ArrayList<String>();
		Hortelanos hortelanos = FactoriaHortelano.leeHortelano2("C:/Users/jomaa/Desktop/socios.csv");
		for(Entry<Integer,Hortelano> e:hortelanos.getHortelanos().entrySet()) {
			String aux = e.getValue().getPersona().getNombre();
			String aux0 = aux.substring(0,1).toUpperCase();
			String auxResto = aux.substring(1,aux.length());
			print(aux0.concat(auxResto.toLowerCase()));
		}
		
		/*Fichero.escribeFichero(aux.get(0), "C:/Users/jomaa/Desktop/hortelanos_importado.csv");
		for(String s:aux.subList(1, aux.size())) {
			Fichero.añadirAlFichero(s, "C:/Users/jomaa/Desktop/hortelanos_importado.csv");
		}*/
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}
}
