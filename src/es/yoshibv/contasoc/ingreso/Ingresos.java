package es.yoshibv.contasoc.ingreso;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Ingresos {
	private SortedMap<Integer,List<Ingreso>> ingresos;

	public Ingresos(SortedMap<Integer,List<Ingreso>> ingresos) {
		super();
		this.ingresos = ingresos;
	}
	
	public SortedMap<Integer,List<Ingreso>> getIngresos() {
		return ingresos;
	}
	
	public List<Ingreso> getIngresosPorNumero(Integer id) {
		return ingresos.get(id);
	}
	
	public void agregarIngreso(Integer id, Ingreso i) {
		List<Ingreso> aux = getIngresosPorNumero(id);
		aux.add(i);
	}
	
	public void eliminarIngreso(Integer id, LocalDate fecha) {
		List<Ingreso> aux = getIngresosPorNumero(id);
		for(Ingreso i:aux) {
			if(i.getFecha().equals(fecha)) {
				aux.remove(i);
				break;
			}
		}
	}
	
	public Double getTotalIngresos() {
		return ingresos.entrySet().stream()
				.map(e->e.getValue()).toList().stream()
				.flatMap(x->x.stream())
				.collect(Collectors.summingDouble(x->x.getCantidad()));
	}
}
