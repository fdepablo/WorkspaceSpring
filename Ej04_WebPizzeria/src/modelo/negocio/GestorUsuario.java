package modelo.negocio;

import modelo.entidades.Usuario;

public class GestorUsuario {
	
	public boolean validarUsuario(Usuario p) {
		return p.getNombre().equals("pepe") && p.getPassword().equals("1234");
	}
}
