package es.yoshibv.contasoc.ingreso;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

import es.yoshibv.contasoc.common.TipoRetribucion;

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
	
	public List<String> getIngresosPorNumeroForPrint(Integer id) {
		return ingresos.get(id).stream().map(x->x.toString()).toList();
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
	
	public Double getTotalIngresos(TipoRetribucion tipo) {
		return ingresos.entrySet().stream()
				.map(e->e.getValue()).toList().stream()
				.flatMap(x->x.stream())
				.filter(x->x.getTipo().equals(tipo))
				.collect(Collectors.summingDouble(x->x.getCantidad()));
	}
}
