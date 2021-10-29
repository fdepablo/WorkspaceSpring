package com.modelo.negocio;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.entidades.Usuario;
import com.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	
	@Autowired
	private DaoUsuario daoUsuario;
	
	public boolean validarUsuario(String username, String password) {
		Optional<Usuario> usuario = daoUsuario.findByNombre(username);		
		return usuario.isPresent() ? true : false;
	}
}
