package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Usuario;
import modelo.persistencia.DAOUsuario;

@Service
public class GestorUsuarios {
	
	@Autowired
	private DAOUsuario daoUsuario;

	public void insertar(Usuario usuario) {
		daoUsuario.insertar(usuario);
	}
	
	public Usuario buscar(Integer id) {
		return daoUsuario.buscar(id);
	}
	
	public boolean buscar(String nombre, String password) {
		boolean result = false;
		List<Usuario> listaUsuarios = daoUsuario.getListaUsuarios();
		for(Usuario usuario : listaUsuarios) {
			if(usuario.getNombre().equals(nombre)) {
				if(usuario.getPassword().equals(password)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	public List<Usuario> getListaUsuarios() {
		return daoUsuario.getListaUsuarios();
	}
	
	public void borrar(Usuario usuario) {
		daoUsuario.borrar(usuario);
	}
	
	public void modificar(Usuario usuario) {
		daoUsuario.modificar(usuario);
	}
	
}
