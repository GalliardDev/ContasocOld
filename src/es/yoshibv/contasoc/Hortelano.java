package es.yoshibv.contasoc;

import java.time.LocalDate;
import java.util.Objects;

import es.yoshibv.contasoc.common.Estado;
import es.yoshibv.contasoc.common.TipoHortelano;
import es.yoshibv.contasoc.util.Checkers;
import es.yoshibv.contasoc.util.Parsers;

public class Hortelano implements Comparable<Hortelano> {
	private Persona persona;
	private Integer socio;
	private String huerto;
	private LocalDate alta;
	private LocalDate baja;
	private Estado estado;
	private TipoHortelano tipo;
	
	public Hortelano(Persona persona, Integer socio, String huerto, LocalDate alta, LocalDate baja, 
			Estado estado, TipoHortelano tipo) {
		super();
		Checkers.checkNoNull(persona,socio,alta,estado,tipo);
		this.persona = persona;
		this.socio = socio;
		this.huerto = huerto;
		this.alta = alta;
		this.baja = baja;
		this.estado = estado;
		this.tipo = tipo;
	}
	
	public Hortelano(String s) {
		String[] t = s.split(";");
		String nombre = t[0];
		String apellidos = t[1];
		String dni = t[2];
		String direccion = t[3];
		String telefono = t[4];
		String correo = t[5];
		String socio = t[6];
		String huerto = t[7];
		String altaStr = t[8];
		String bajaStr = t[9];
		String estado = t[10];
		String tipo = t[11];
		
		Persona p = new Persona(nombre,apellidos,dni,direccion,telefono,correo);
		
		this.persona = p;
		this.socio = Integer.valueOf(socio);
		this.huerto = huerto;
		String[] altaArr = altaStr.split("/");
		LocalDate alta = LocalDate.of(Integer.valueOf(altaArr[2]),Integer.valueOf(altaArr[1]),Integer.valueOf(altaArr[0]));
		String[] bajaArr = bajaStr.split("/");
		LocalDate baja = null;
		if(bajaArr.length == 3) {
			baja = LocalDate.of(Integer.valueOf(bajaArr[2]),Integer.valueOf(bajaArr[1]),Integer.valueOf(bajaArr[0]));
		} else {
			baja = null;
		}
		this.alta = alta;
		this.baja = baja;
		this.estado = Estado.valueOf(estado);
		this.tipo = TipoHortelano.valueOf(tipo);
	}
	
	public Integer getSocio() {
		return socio;
	}

	public void setSocio(Integer socio) {
		this.socio = socio;
	}

	public String getHuerto() {
		return huerto;
	}

	public void setHuerto(String huerto) {
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

	public TipoHortelano getTipo() {
		return tipo;
	}

	public void setTipo(TipoHortelano tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
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
				estado+";"+tipo;
	}
	
}
