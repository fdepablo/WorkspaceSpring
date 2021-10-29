package com.modelo.persistencia;

import java.util.List;

import com.modelo.entidades.Usuario;

public interface DaoUsuario {
	
	public List<Usuario> listar();
	public Usuario obtenerUsuarioPorUsername(String username);
}
