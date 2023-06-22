package es.yoshibv.contasoc;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.Tipo;
import es.yoshibv.contasoc.ingreso.Ingreso;
import es.yoshibv.contasoc.util.Checkers;
import es.yoshibv.contasoc.util.Parsers;

public class Hortelano implements Comparable<Hortelano> {
	private Persona persona;
	private Integer socio;
	private Integer huerto;
	private LocalDate alta;
	private LocalDate baja;
	private Estado estado;
	private Tipo tipo;
	private List<Ingreso> ingresos;
	
	public Hortelano(Persona persona, Integer socio, Integer huerto, LocalDate alta, LocalDate baja, 
			Estado estado, Tipo tipo) {
		super();
		Checkers.checkNoNull(persona,socio,huerto,alta,estado,tipo);
		this.persona = persona;
		this.socio = socio;
		this.huerto = huerto;
		this.alta = alta;
		this.baja = baja;
		this.estado = estado;
		this.tipo = tipo;
		this.ingresos = new ArrayList<Ingreso>();
	}

	public Integer getSocio() {
		return socio;
	}

	public void setSocio(Integer socio) {
		this.socio = socio;
	}

	public Integer getHuerto() {
		return huerto;
	}

	public void setHuerto(Integer huerto) {
		this.huerto = huerto;
	}

	public LocalDate getAlta() {
		return alta;
	}

	public void setAlta(LocalDate alta) {
		this.alta = alta;
	}

	public LocalDate getBaja() {
		return baja;
	}

	public void setBaja(LocalDate baja) {
		this.baja = baja;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}
	
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	public void añadirIngreso(Ingreso ingreso) {
		this.ingresos.add(ingreso);
	}
	
	public void eliminarIngreso(Ingreso ingreso) {
		this.ingresos.remove(ingreso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(socio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hortelano other = (Hortelano) obj;
		return Objects.equals(socio, other.socio);
	}

	@Override
	public int compareTo(Hortelano h) {
		// TODO Auto-generated method stub
		return socio.compareTo(h.getSocio());
	}

	@Override
	public String toString() {
		return persona.getNombre()+";"+persona.getApellidos()+";"+persona.getDni()+";"+
				persona.getDireccion()+";"+persona.getTelefono()+";"+persona.getCorreo()+";"+
				socio+";"+huerto+";"+Parsers.dateParser(alta)+";"+Parsers.dateParser(baja)+";"+
				estado+";"+tipo+";"+ingresos;
	}
	
}
