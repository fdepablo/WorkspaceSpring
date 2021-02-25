package modelo.persistencia;

import java.util.List;

import modelo.entidades.Coche;

public class DaoCoche {
	
	private List<Coche> listaCoches;
	
	public void altaCoche(Coche c) {
		listaCoches.add(c);
	}
	
	public List<Coche> listarCoches() {
		return listaCoches;
	}

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	
	public boolean hayCoche(Coche c) {
		return listaCoches.contains(c);
	}

}
