package entidades;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Pedido {

	private List <Ordenador> ordenadores;
	private double precio;
	
	
	
	
	public Pedido() {
		ordenadores = new LinkedList <Ordenador> ();
	}
	public List<Ordenador> getOrdenadores() {
		return ordenadores;
	}
	public void setOrdenadores(List<Ordenador> ordenadores) {
		this.ordenadores = ordenadores;
	}
	
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
	
}
