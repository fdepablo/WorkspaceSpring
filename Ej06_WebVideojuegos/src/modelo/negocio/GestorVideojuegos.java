package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Videojuego;
import modelo.persistencia.DAOVideojuego;

@Service
public class GestorVideojuegos {
	
	@Autowired
	private DAOVideojuego daoVideojuego;

	public List<Videojuego> getListaVideojuegos() {
		return daoVideojuego.listarVideojuegos();
	}

	public void insertar(Videojuego videojuego) {
		daoVideojuego.insertar(videojuego);
	}
	
	public Videojuego buscar(Integer id) {
		return daoVideojuego.buscar(id);
	}
	
	public void borrar(Videojuego videojuego) {
		daoVideojuego.borrar(videojuego);
	}
	
	public void modificar(Videojuego videojuego) {
		daoVideojuego.modificar(videojuego);
	}
	
}
