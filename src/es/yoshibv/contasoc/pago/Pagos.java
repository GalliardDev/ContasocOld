package es.yoshibv.contasoc.pago;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Pagos {
	private SortedMap<String,List<Pago>> pagos;

	public Pagos(SortedMap<String,List<Pago>> pagos) {
		super();
		this.pagos = pagos;
	}

	public SortedMap<String,List<Pago>> getPagos() {
		return pagos;
	}
	
	public List<Pago> getPagosPorFecha(LocalDate f) {
		return getPagos().entrySet().stream()
				.map(e->e.getValue())
				.flatMap(x->x.stream())
				.filter(x->x.getFecha().equals(f))
				.sorted(Comparator.comparing(Pago::getFecha))
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista)));
	}
	
	public List<Pago> getPagosPorProveedor(String p){
		return getPagos().entrySet().stream()
				.map(e->e.getValue())
				.flatMap(x->x.stream())
				.filter(x->x.getProveedor().equals(p))
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista)));
	}
		
}
