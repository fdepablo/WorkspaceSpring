package modelo.negocio;

import modelo.entidades.Pedido;
import modelo.entidades.Pizza;

public class GestorPedido {
	public int calcularPrecio(Pizza p) {
		int precioTotal = 0;
		
		if (p.getTam().equals("pequenia")) {
		 	precioTotal = 5;
		} else if (p.getTam().equals("mediana")) {
			precioTotal = 10;
		} else if (p.getTam().equals("grande")) {
			precioTotal = 15;
		}
		
		precioTotal += p.getListaIngredientes().size();
		
		return precioTotal;
	}
	
	public boolean validarPedido(Pedido p) {
		if(p.getUsuario().getDireccion() != null &&
				!p.getUsuario().getDireccion().equals("")) {
			if(p.getUsuario().getTelefono() != null && 
					!p.getUsuario().getTelefono().equals("")) {
				return true;
			}
		}
		return false;
		
	}
}
