package modelo.persistencia;

import java.util.List;

import modelo.entidades.Usuario;

public interface DAOUsuario {
	void insertar(Usuario usuario);
	void modificar(Usuario usuario);
	void borrar(Usuario usuario);
	Usuario buscar(Integer id);
	Usuario buscar(String nombre, String password);
	List<Usuario> getListaUsuarios();
}
