package es.yoshibv.contasoc.pago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Pagos {
	private List<Pago> pagos;

	public Pagos(ArrayList	<Pago> pagos) {
		super();
		this.pagos = pagos;
	}

	public List<Pago> getPagos() {
		return pagos;
	}
	
	public Double getTotalPagos() {
		return pagos.stream()
		.collect(Collectors.summingDouble(x->x.getCantidad()));
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
	
	public Pago getPagoPorFactura(String f) {
		return getPagos().stream()
				.filter(x->x.getFactura().equals(f))
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista))).get(0);
	}
	
	public void eliminarPago(Pago p) {
		pagos.remove(p);
	}
		
}
