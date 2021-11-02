package es.curso.modelo.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Usuario;

@Repository
public interface DaoUsuario extends JpaRepository<Usuario, Integer>{
	public Optional<Usuario> findByNombre(String nombre);
}
