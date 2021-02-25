package curso.modelo.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.modelo.entidades.Usuario;

public interface DaoUsuario extends JpaRepository<Usuario, Integer>{
	
	public Optional<Usuario> findByNombre(String nombre);

}
