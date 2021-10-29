package com.modelo.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.entidades.Usuario;

public interface DaoUsuario extends JpaRepository<Usuario, Integer>{
	//Se puede devolver un optinal sin problema
	public Optional<Usuario> findByNombre(String nombre);
}
