package es.curso.modelo.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import es.curso.modelo.entidades.Pelicula;

/**
 * Esta clase se encarga de conviertir automatimente los registros devueltos
 * por JdbcTemplate a objetos
 */
@Component
public class DaoPeliculaRowMapper implements RowMapper<Pelicula>{

	
	//Spring le pasara automaticamente el ResultSet, y la fila del ResultSet
	//con la que esta trabajando
	@Override
	public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pelicula p = new Pelicula();
		p.setId(rs.getInt("ID"));
		p.setDirector(rs.getString("DIRECTOR"));
		p.setGenero(rs.getString("GENERO"));
		p.setTitulo(rs.getString("TITULO"));
		p.setYear(rs.getInt("YEAR"));
		return p;
	}

}
