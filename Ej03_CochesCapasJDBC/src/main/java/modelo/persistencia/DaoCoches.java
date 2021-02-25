package modelo.persistencia;

import java.util.List;

import modelo.entidades.Coche;

public interface DaoCoches {
	void insertar(Coche c);
	void modificar(Coche c);
	void borrar(Coche c);
	Coche buscar(int id);
	List<Coche> listar();
	List<Coche> ordenarMarca();
	List<Coche> ordenarModelo();
	
	boolean hayCoche(Coche c);

}
