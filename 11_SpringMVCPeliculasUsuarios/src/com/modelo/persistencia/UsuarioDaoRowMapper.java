package com.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.modelo.entidades.Usuario;

@Component
public class UsuarioDaoRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario u = new Usuario();
		u.setId(rs.getInt("ID"));
		u.setNombre(rs.getString("NOMBRE"));
		u.setPassword(rs.getString("PASSWORD"));
		return u;
	}

}
