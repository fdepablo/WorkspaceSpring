package com.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.modelo.entidades.Pelicula;

@Component
public class PeliculaDaoRowMapper implements RowMapper<Pelicula>{

	@Override
	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula p = new Pelicula();
		p.setId(rs.getInt("ID"));
		p.setTitulo(rs.getString("TITULO"));
		p.setGenero(rs.getString("GENERO"));
		p.setYear(rs.getInt("YEAR"));
		return p;
	}

}
