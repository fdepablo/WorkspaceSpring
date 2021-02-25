package com.modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.modelo.entidades.Usuario;

@Repository
public class DaoUsuarioMySql implements DaoUsuario{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UsuarioDaoRowMapper usuarioDaoRowMapper;
	
	@Override
	public List<Usuario> listar() {
		String query = "select * from usuarios";
		List<Usuario> listaUsuarios = 
				jdbcTemplate.query(query,usuarioDaoRowMapper );
		return listaUsuarios; 
	}

	@Override
	public boolean validarUsuario(Usuario u) {
		String query = "select * from usuarios where nombre=?"
				+ " and password =?";
		Usuario usuario;
		try {
			usuario = jdbcTemplate.queryForObject(query, 
					usuarioDaoRowMapper,
					u.getNombre(),
					u.getPassword());
			return true;
		} catch (DataAccessException e) {
			return false;
		}

	}

	
}








