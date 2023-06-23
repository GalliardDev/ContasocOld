package es.yoshibv.contasoc.pago;

import java.time.LocalDate;
import java.util.Objects;

public class Pago implements Comparable<Pago> {
	private LocalDate fecha;
	private String proveedor;
	private String concepto;
	private Double cantidad;
	private String factura;
	
	public Pago(LocalDate fecha, String proveedor, String concepto, Double cantidad, String factura) {
		super();
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.factura = factura;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, concepto, factura, fecha, proveedor);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pago other = (Pago) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(concepto, other.concepto)
				&& Objects.equals(factura, other.factura) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(proveedor, other.proveedor);
	}
	
	@Override
	public int compareTo(Pago o) {
		// TODO Auto-generated method stub
		return proveedor.compareTo(o.proveedor);
	}

	@Override
	public String toString() {
		return fecha+";"+proveedor+";"+concepto+";"+cantidad+";"+factura;
	}
}
