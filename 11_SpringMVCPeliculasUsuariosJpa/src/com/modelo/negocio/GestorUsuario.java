package com.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.entidades.Usuario;
import com.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	
	@Autowired
	private DaoUsuario daoUsuario;
	
	public boolean validarUsuario(Usuario u) {
		//comprobaciones del tipo nombre no esta 
		//vacio, etc
		return daoUsuario.validarUsuario(u);
	}
}
