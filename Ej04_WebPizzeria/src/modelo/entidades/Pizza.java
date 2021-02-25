package modelo.entidades;

import java.util.List;

public class Pizza {
	
	private String tam;
	
	private List<String> listaIngredientes;
	
	public Pizza() {
		super();
	}

	public Pizza(String tam, List<String> listaIngredientes) {
		super();
		this.tam = tam;
		this.listaIngredientes = listaIngredientes;
	}

	public String getTam() {
		return tam;
	}

	public void setTam(String tam) {
		this.tam = tam;
	}

	public List<String> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<String> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}
}
