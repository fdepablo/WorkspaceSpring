package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.DAOPelicula;

@Service
public class GestorPeliculas {
	
	@Autowired
	private DAOPelicula daoPelicula;
	//Notese que si usamos anotaciones no necesitamos
	//hacer el set y el get del dao!! Java hace la inyeccion
	//mediante reflection
	
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
}
