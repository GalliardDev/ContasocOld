package es.yoshibv.contasoc.listaespera;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import es.yoshibv.contasoc.Hortelano;
import es.yoshibv.contasoc.Main;
import es.yoshibv.contasoc.common.Tipo;

public class ListaEsperaGetter {
	private List<Hortelano> hortelanos;
	
	public ListaEsperaGetter() {
		this.hortelanos = new ArrayList<Hortelano>();
	}
	
	public List<Hortelano> getHortelanos() {
		List<Hortelano> aux = new ArrayList<Hortelano>();
		try {
			aux = Files.readAllLines(Path.of(Main.HORTELANOS)).stream()
					.map(x->new Hortelano(x))
					.sorted(Comparator.comparing(Hortelano::getAlta))
					.toList();
		} catch(IOException e) {
			e.printStackTrace();
		}
		aux.stream().filter(x->x.getTipo().equals(Tipo.LISTA_ESPERA)).forEach(x->hortelanos.add(x));
		return hortelanos;
	}
		
}
