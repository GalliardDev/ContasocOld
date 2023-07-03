package es.yoshibv.contasoc;

import java.util.Objects;

import es.yoshibv.contasoc.util.Checkers;

public class Persona {
	private String nombre;
	private String apellidos;
	private String dni;
	private String direccion;
	private String telefono;
	private String correo;
	
	public Persona(String nombre, String apellidos, String dni, String direccion, String telefono, String correo) {
		super();
		Checkers.checkNoNull(nombre,apellidos,dni,direccion);	
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getNombreYApellidos() {
		return this.nombre +" "+ this.apellidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}	
}
