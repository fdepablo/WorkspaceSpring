package es.curso.modelo.persistencia;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Usuario;

@Repository
public interface DaoUsuario extends MongoRepository<Usuario, Integer>{
	public Optional<Usuario> findByNombre(String nombre);
}
