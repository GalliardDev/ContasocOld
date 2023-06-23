package es.yoshibv.contasoc.ingreso;

import java.util.List;
import java.util.SortedMap;

public class Ingresos {
	private SortedMap<Integer,List<Ingreso>> ingresos;

	public Ingresos(SortedMap<Integer,List<Ingreso>> ingresos) {
		super();
		this.ingresos = ingresos;
	}
	
	public SortedMap<Integer,List<Ingreso>> getIngresos() {
		return ingresos;
	}
}
