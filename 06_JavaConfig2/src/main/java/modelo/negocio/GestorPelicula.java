package modelo.negocio;

import modelo.entidades.Pelicula;
import modelo.persistencia.DAOPelicula;

public class GestorPelicula {
	
	private DAOPelicula daoPelicula;
	
	public boolean insertar(Pelicula p) {
		if(p.getTitulo().equals("")) {
			return false;
		}else {
			return daoPelicula.insertar(p);
		}
	}

	public DAOPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DAOPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	
}
