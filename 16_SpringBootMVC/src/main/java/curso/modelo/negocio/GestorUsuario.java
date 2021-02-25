package curso.modelo.negocio;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.controladores.ControladorPelicula;
import curso.modelo.entidades.Usuario;
import curso.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	
	Logger logger = LoggerFactory.getLogger(GestorUsuario.class);
	
	@Autowired
	private DaoUsuario daoUsuario;
	
	public boolean validar(Usuario u) {
		//comprobaciones del tipo nombre no esta 
		//vacio, etc
		Optional<Usuario> usuarioOp = daoUsuario.findByNombre(u.getNombre());
		if(usuarioOp.isPresent()) {
			Usuario usuarioAux = usuarioOp.get();
			if(u.getPassword().equals(usuarioAux.getPassword())) {
				logger.info("Usuario " + u.getNombre() + " validado");
				return true;
			}
		}
		logger.info("Usuario " + u.getNombre() + "NO validado");
		return false;
	}
	
	public Usuario insertar(Usuario usuario) {
		Usuario usuarioAux = daoUsuario.save(usuario);
		logger.info("Insertar -> Usuario con id " + usuarioAux.getId() + " insertado");
		return usuarioAux;
	}
}
