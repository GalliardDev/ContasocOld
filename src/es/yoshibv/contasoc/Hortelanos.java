package es.yoshibv.contasoc;

import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

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
	
	public Hortelano getHortelanoPorNumeroDeHuerto(String id) {
		return hortelanos.entrySet().stream()
				.filter(e->e.getValue().getHuerto().equals(id))
				.map(x->x.getValue())
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista).get(0)));
	}
	
	public List<String> getNombreHortelanoPorNumeroDeSocio(Integer id) {
		return hortelanos.entrySet().stream()
				.filter(e->e.getValue().getSocio().equals(id))
				.map(x->x.getValue())
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista).stream().map(x->x.getPersona().getNombreYApellidos()).toList()));
	}
	
	public Hortelano getHortelanoPorNombreCompleto(String nc) {
		return hortelanos.entrySet().stream()
				.filter(e->String.join(" ", List.of(e.getValue().getPersona().getNombre(),e.getValue().getPersona().getApellidos())).equals(nc))
				.map(x->x.getValue())
				.collect(Collectors.collectingAndThen(
						Collectors.toList(),
						lista->List.copyOf(lista).get(0)));
	}
	
	public void eliminarHortelano(Integer id) {
		hortelanos.remove(id);
	}
	
}
