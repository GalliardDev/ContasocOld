package es.yoshibv.contasoc.test;

import java.util.List;

import es.yoshibv.contasoc.Hortelano;
import es.yoshibv.contasoc.listaespera.ListaEsperaGetter;

public class TestListaEspera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEsperaGetter le = new ListaEsperaGetter();
		List<Hortelano> aux = le.getHortelanos();
		print(aux);
	}
	
	private static void print(Object o) {
		System.out.println(o);
	}

}
