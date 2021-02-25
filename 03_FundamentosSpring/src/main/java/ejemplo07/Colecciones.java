package ejemplo07;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Colecciones {
	private List<Persona> listaPersonas;
	private Set<String> conjuntoStrings;
	private Map<Integer,Persona> mapaPersonas;
	
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	public Set<String> getConjuntoStrings() {
		return conjuntoStrings;
	}
	public void setConjuntoStrings(Set<String> conjuntoStrings) {
		this.conjuntoStrings = conjuntoStrings;
	}
	public Map<Integer, Persona> getMapaPersonas() {
		return mapaPersonas;
	}
	public void setMapaPersonas(Map<Integer, Persona> mapaPersonas) {
		this.mapaPersonas = mapaPersonas;
	}
	
	
}
