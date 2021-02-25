package modelo.persistencia;

import java.util.List;

import modelo.entidades.Videojuego;

public interface DAOVideojuego {
	void insertar(Videojuego videojuego);
	void modificar(Videojuego videojuego);
	void borrar(Videojuego videojuego);
	Videojuego buscar(Integer id);
	List<Videojuego> listarVideojuegos();
}
