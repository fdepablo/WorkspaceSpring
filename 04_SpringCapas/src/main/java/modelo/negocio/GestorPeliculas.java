package modelo.negocio;

import java.util.List;

import modelo.entidades.Pelicula;
import modelo.persistencia.DAOPelicula;

public class GestorPeliculas {
	
	private DAOPelicula daoPelicula;
	
	//Aqui posiblemente lo suyo seria mandar
	//mas señales que true o false (un int) para así poder
	//saber en la capa de cliente si ha fallado
	//porque el titulo esta vacio (0), porque la bbdd
	//esta llena (1) o todo ha ido bien (2)
	public boolean insertar(Pelicula p) {
		if(p.getTitulo().equals("")) {
			return false;
		}else {
			return daoPelicula.insertar(p);
		}
	}
	
	public List<Pelicula> listar(){
		return daoPelicula.listar();
	}

	public DAOPelicula getDaoPelicula() {
		return daoPelicula;
	}

	public void setDaoPelicula(DAOPelicula daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	
}
