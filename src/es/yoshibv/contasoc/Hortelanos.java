package es.yoshibv.contasoc;

import java.util.Arrays;
import java.util.SortedMap;

public class Hortelanos {
	private SortedMap<Integer,Hortelano> hortelanos;

	public Hortelanos(SortedMap<Integer,Hortelano> hortelanos) {
		super();
		this.hortelanos = hortelanos;
	}
	
	public SortedMap<Integer,Hortelano> getHortelanos() {
		return hortelanos;
	}
	
	public Hortelano getHortelanoPorNumero(Integer id) {
		return hortelanos.get(id);
	}
	
	public Hortelano getHortelanoPorNombreCompleto(String nc) {
		String[] aux = nc.split(" ");
		String[] nomArr = Arrays.copyOfRange(aux, 0, aux.length-3);
		String[] apeArr = Arrays.copyOfRange(aux, aux.length-2, aux.length-1);
		String auxNombre = String.join(" ",nomArr);
		String auxApellidos = String.join(" ",apeArr);

		
		String nombre = new String(auxNombre);
		String apellidos = new String(auxApellidos);
		System.out.println(nombre);
		System.out.println(apellidos);
		
		return getHortelanos().entrySet().stream()
				.filter(x->(x.getValue().getPersona().getNombre().equals(nombre) && x.getValue().getPersona().getApellidos().equals(apellidos)))
				.findFirst().get().getValue();
		}
		
}
