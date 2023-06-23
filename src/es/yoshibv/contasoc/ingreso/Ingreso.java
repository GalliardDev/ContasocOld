package es.yoshibv.contasoc.ingreso;

import java.time.LocalDate;
import java.util.Objects;

import es.yoshibv.contasoc.common.Cuota;
import es.yoshibv.contasoc.util.Parsers;

public class Ingreso implements Comparable<Ingreso> {
	private LocalDate fecha;
	private String concepto;
	private Double cantidad;
	private Cuota cuota;
	
	public Ingreso(LocalDate fecha, String concepto, Double cantidad, Cuota cuota) {
		super();
		this.fecha = fecha;
		this.concepto = concepto;
		this.cantidad = cantidad;
		this.cuota = cuota;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingreso other = (Ingreso) obj;
		return Objects.equals(fecha, other.fecha);
	}

	@Override
	public int compareTo(Ingreso p) {
		// TODO Auto-generated method stub
		return fecha.compareTo(p.fecha);
	}

	@Override
	public String toString() {
		return Parsers.dateParser(fecha)+"-"+concepto+"-"+cantidad+"-"+cuota;
	}
		
}
