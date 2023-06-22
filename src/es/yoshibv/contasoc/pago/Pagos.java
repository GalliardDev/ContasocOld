package es.yoshibv.contasoc.pago;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class Pagos {
	private SortedSet<Pago> pagos;

	public Pagos(SortedSet<Pago> pagos) {
		super();
		this.pagos = pagos;
	}

	public SortedSet<Pago> getPagos() {
		return pagos;
	}
	
	public List<Pago> getPagosPorFecha(LocalDate f) {
		return getPagos().stream()
				.filter(x->x.getFecha().equals(f))
				.sorted(Comparator.comparing(Pago::getFecha))
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista)));
	}
	
	public List<Pago> getPagosPorProveedor(String p){
		return getPagos().stream()
				.filter(x->x.getProveedor().equals(p))
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista)));
	}
		
}
